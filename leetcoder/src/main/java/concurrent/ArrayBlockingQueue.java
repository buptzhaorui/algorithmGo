package concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * User: zhaorui
 * Date: 2017/4/3
 * Time: 13:03
 */
public class ArrayBlockingQueue<E> {
  final Object[] items;
  int takeIndex;
  int putIndex;
  int count;
  final ReentrantLock lock;
  private final Condition notEmpty;
  private final Condition notFull;

  ArrayBlockingQueue(int capacity){
    items = new Object[capacity];
    lock = new ReentrantLock();
    notEmpty = lock.newCondition();
    notFull = lock.newCondition();
  }

  private void checkNotNull(E item){
    if(item == null) throw new NullPointerException();
  }

  private int inc(int index){
    if(index == items.length-1) return 0;
    else return index + 1;
  }

  private void insert(E item){
    items[putIndex] = item;
    putIndex = inc(putIndex);
    count++;
    notEmpty.signalAll();
  }

  boolean offer(E item){
    checkNotNull(item);
    lock.lock();
    try {
      if(count == items.length){
        return false;
      }else{
        insert(item);
        return true;
      }
    } finally {
      lock.unlock();
    }
  }

  void put(E item) throws InterruptedException {
    checkNotNull(item);
    lock.lockInterruptibly();
    try{
      while(count == items.length)
        notFull.await();
      insert(item);
    }finally {
      lock.unlock();
    }
  }

  private E extract(){
    E x = (E) items[takeIndex];
    items[takeIndex] = null;
    takeIndex = inc(takeIndex);
    count--;
    notFull.signalAll();
    return x;
  }

  E poll(){
    lock.lock();
    try{
      return count == 0 ? null : extract();
    }finally{
      lock.unlock();
    }
  }

  E take() throws InterruptedException {
    lock.lockInterruptibly();
    try {
      while(count == 0) notEmpty.await();
      return extract();
    } finally {
      lock.unlock();
    }
  }


  private void removeAt(int i){
    if(i == takeIndex){
      items[takeIndex] = null;
      takeIndex = inc(takeIndex);
    }else{
      for(;;){
        int nexti = inc(i);
        if(nexti != putIndex){
          items[i] = items[nexti];
          i = nexti;
        }else{
          items[i] = null;
          putIndex = i;
          break;
        }
      }
    }
    count--;
    notFull.signalAll();
  }

  boolean remove(Object o){
    if(o == null) return false;
    lock.lock();
    try{
      for(int i = takeIndex, k = count; k > 0; k--, i = inc(i)){
        if(o.equals(items[i])){
          removeAt(i);
          return true;
        }
      }
      return false;
    }finally {
      lock.unlock();
    }
  }

}

package concurrent;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * User: zhaorui
 * Date: 2017/3/18
 * Time: 21:32
 */
public class BoundedHashSet<T> {
  private final Set<T> set;
  private final Semaphore sem;

  public BoundedHashSet(int bound){
    set = Collections.synchronizedSet(new HashSet<T>());
    sem = new Semaphore(bound);
  }

  public boolean add(T t) throws InterruptedException {
    sem.acquire();
    boolean wasAdded = false;
    try{
      wasAdded = set.add(t);
      return wasAdded;
    } finally {
      if(!wasAdded) sem.release();
    }
  }

  public boolean remove(T t) {
    boolean wasRemoved = set.remove(t);
    if(wasRemoved) sem.release();
    return wasRemoved;
  }
}

package concurrent;

import java.util.concurrent.atomic.AtomicReference;

/**
 * User: zhaorui
 * Date: 2017/3/17
 * Time: 20:41
 */
public class ConcurrentStack<E> {
  private static class Node<E> {
    E item;
    Node<E> next;

    public Node(E e){
      item = e;
    }
  }

  AtomicReference<Node<E>> top = new AtomicReference<>();

  public void push(E item){
    Node<E> newHead = new Node<E>(item);
    Node<E> oldHead;
    do{
      oldHead = top.get();
      newHead.next = oldHead;
    }while(!top.compareAndSet(oldHead, newHead));
  }

  public Node<E> pop(){
    Node<E> newHead;
    Node<E> oldHead;
    do{
      oldHead = top.get();
      if(oldHead == null) return null;
      newHead = oldHead.next;
    }while(top.compareAndSet(oldHead, newHead));
    return oldHead;
  }
}
package concurrent;

/**
 * User: zhaorui
 * Date: 2017/3/14
 * Time: 20:25
 */
public class ThreadLocalDemo implements Runnable {
  static class O{
    int i;
    O(int i){
      this.i = i;
    }
  }
  static ThreadLocal<O> local = new ThreadLocal<>();
  private O o;

  public ThreadLocalDemo(int i){
    this.o = new O(i);
  }

  @Override
  public void run() {
    local.set(o);

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Thread" + o.i + ":" + local.get().i);
  }

  public static void main(String[] args) throws InterruptedException {
    for(int i = 0; i < 10; i++){
      new Thread(new ThreadLocalDemo(i)).start();
    }

    Thread.sleep(10000);
  }
}

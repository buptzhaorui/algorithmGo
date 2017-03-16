package concurrent;

/**
 * User: zhaorui
 * Date: 2017/3/14
 * Time: 20:25
 */
public class ThreadLocalDemo implements Runnable {
  static ThreadLocal<Integer> local = new ThreadLocal<>();
  private int i;

  public ThreadLocalDemo(int i){
    this.i = i;
  }

  @Override
  public void run() {
    local.set(i);

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Thread" + i + ":" + local.get());
  }

  public static void main(String[] args) throws InterruptedException {
    for(int i = 0; i < 10; i++){
      new Thread(new ThreadLocalDemo(i)).start();
    }

    Thread.sleep(10000);
  }
}

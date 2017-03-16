package concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * User: zhaorui
 * Date: 2017/3/16
 * Time: 20:39
 */
public class CountDownLatchDemo {
  public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
    final CountDownLatch startLatch = new CountDownLatch(1);
    final CountDownLatch endLatch = new CountDownLatch(nThreads);

    for(int i = 0; i < nThreads; i++){
      Thread t = new Thread(){
        @Override
        public void run(){
          try {
            startLatch.await();
            try {
              task.run();
            } finally {
              endLatch.countDown();
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }

        }
      };
      t.start();
    }

    long start = System.currentTimeMillis();
    startLatch.countDown();
    endLatch.await();
    long end = System.currentTimeMillis();
    return end-start;
  }
}

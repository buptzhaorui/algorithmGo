package concurrent;

/**
 * User: zhaorui
 * Date: 2017/3/16
 * Time: 13:10
 */
public class InterruptionDemo {
  public static void main(String[] args){
    Thread  t = new Thread(new TaskRunnable());

    t.start();
    try{
      Thread.sleep(2000);
    }catch (Exception e){
      e.printStackTrace();
    }
    t.interrupt();
  }
}

class TaskRunnable implements Runnable {
  @Override
  public void run(){
    try{
      Thread.sleep(10000);
    } catch (Exception e){
      throw new RuntimeException();
    }
  }

  private void throwException() throws InterruptedException {
    throw new InterruptedException();
  }
}

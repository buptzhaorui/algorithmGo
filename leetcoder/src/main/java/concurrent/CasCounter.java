package concurrent;

import sun.misc.Unsafe;

/**
 * User: zhaorui
 * Date: 2017/3/17
 * Time: 19:29
 */
public class CasCounter {
  private static final Unsafe unsafe = Unsafe.getUnsafe(); //会报错，Unsafe类必须由boot加载器加载
  private static final long valueOffset;

  static {
    try {
      valueOffset = unsafe.objectFieldOffset
        (CasCounter.class.getDeclaredField("value"));
    } catch (Exception ex) { throw new Error(ex); }
  }
  private int value;

  public CasCounter(int v){
    value = v;
  }

  public int getValue(){
    return value;
  }

  public int increment(){
    while(unsafe.compareAndSwapInt(this, valueOffset, value, value+1));
    return value+1;
  }

  public static void main(String[] args){
    CasCounter counter = new CasCounter(0);
    for(int i = 0; i < 10000; i++){
      new Thread(){
        @Override
        public void run(){
          counter.increment();
        }
      }.start();
    }

    System.out.println(counter.getValue());
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

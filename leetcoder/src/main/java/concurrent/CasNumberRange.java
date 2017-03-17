package concurrent;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.concurrent.atomic.AtomicReference;

/**
 * User: zhaorui
 * Date: 2017/3/17
 * Time: 20:17
 */
public class CasNumberRange {
  @Immutable
  private static class IntPair {
    final int lower;
    final int upper;

    public IntPair(int l, int u){
      lower = l;
      upper = u;
    }
  }

  private final AtomicReference<IntPair> pair = new AtomicReference<>(new IntPair(0, 0));

  public void setLower(int i){
    while(true){
      IntPair oldp = pair.get();
      if(i > oldp.upper){
        throw new IllegalArgumentException("");
      }
      IntPair newp = new IntPair(i, oldp.upper);
      if(pair.compareAndSet(oldp, newp)) return;
    }
  }
}

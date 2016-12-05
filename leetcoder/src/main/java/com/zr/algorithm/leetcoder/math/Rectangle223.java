package com.zr.algorithm.leetcoder.math;

/**
 * User: zhaorui
 * Date: 2016/12/5
 * Time: 22:49
 */
public class Rectangle223 {
  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int w = 0, h = 0;
    if(A <= E && E <= C && C <= G){
      w = C - E;
    }else if(A <= E && G <= C){
      w = G - E;
    }else if(E <= A && A <= G && G <= C){
      w = G - A;
    }else if(E <= A && C <= G){
      w = C - A;
    }

    if(B <= F && F <= D && D <= H){
      h = D - F;
    }else if(B <= F && H <= D){
      h = H - F;
    }else if(F <= B && B <= H && H<=D){
      h = H - B;
    }else if(F <= B && D <= H){
      h = D - B;
    }

    return (C- A)*(D-B)+(G-E)*(H-F)-w*h;
  }

  public int computeArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
    int area1 = (C-A) * (D-B);
    int area2 = (G-E) * (H-F);

    int overlapRegion = overlap(A, B, C, D, E, F, G, H);
    return area1 + area2 - overlapRegion;
  }

  private int overlap(int A, int B, int C, int D, int E, int F, int G, int H) {
    int h1 = Math.max(A, E);
    int h2 = Math.min(C, G);
    int h = h2 - h1;

    int v1 = Math.max(B, F);
    int v2 = Math.min(D, H);
    int v = v2 - v1;

    if(h<=0 || v<=0) return 0;
    else return h*v;
  }
}

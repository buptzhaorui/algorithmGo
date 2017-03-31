package company;

import java.util.Scanner;

/**
 * User: zhaorui
 * Date: 2017/3/31
 * Time: 18:53
 */
public class Main {
  static double p = 0d, q = 0d;
  static int n = 0;
  static double expect = 0d;
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    p = in.nextDouble() / 100;
    q = in.nextDouble() / 100;
    n = in.nextInt();

    if(n == 0){
      System.out.println("0.00");
      return;
    }
    dfs(p, 1, 1, true, p);
    dfs(1-p, 1, 0, false, 1-p);
    System.out.printf("%.2f\n", expect);
  }

  static void dfs(double totalP, int step, int level, boolean lastChoice, double lastP){
    System.out.println(totalP + " " +step + " " + level + " " + lastChoice + " " + lastP);
    if(level == n){
      expect += step*totalP;
      return;
    }

    if(lastChoice){
      double pp = p / (1 << level);
      dfs(totalP * pp, step+1, level+1, true, pp);
      dfs(totalP * (1-pp), step+1, level, false, 1-pp);
    }else{
      double pp = lastP + q > 1 ? 1: lastP + p;
      dfs(totalP * pp, step+1, level+1, true, pp);
      if(pp < 1) dfs(totalP * (1-pp), step+1, level, false, 1-pp);
    }
  }
}


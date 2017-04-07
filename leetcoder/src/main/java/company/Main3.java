package company;

import java.util.Scanner;

/**
 * User: zhaorui
 * Date: 2017/3/31
 * Time: 20:46
 */
public class Main3 {

  public static void main(String[] args){

    Scanner in = new Scanner(System.in);
    int n = in.nextInt(), k = in.nextInt();
    int rst2 = n/(k+k+1);
    int remain = n%(k+k+1);
    int rst1 = remain/(k+1);
    remain = remain%(k+1);
    if(remain == k)
      rst1++;
    System.out.println(rst2*2+rst1);

  }
}

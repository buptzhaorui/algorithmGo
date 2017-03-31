package company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * User: zhaorui
 * Date: 2017/3/31
 * Time: 20:15
 */
public class Main2 {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt(), M = scanner.nextInt(), K = scanner.nextInt();
    int[] levelNum = new int[M+1];
    for(int i = 1; i <= M; i++) levelNum[i] = scanner.nextInt();
    ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    for(int i = 1; i <= M; i++){
      ArrayList<Integer> tmp = new ArrayList<>();
      for(int j = 1; j <= levelNum[i]; j++) tmp.add(scanner.nextInt());
      nodes.add(tmp);
    }

    int[] leaves = new int[K+1];
    for(int i = 1; i <= K; i++) leaves[i] = scanner.nextInt();

    int[][] dist = new int[K+1][K+1];
    for(int i = 1; i <= K; i++){
      for(int j = 1; j <= K; j++){
        dist[i][j] = scanner.nextInt();
      }
    }




  }

}

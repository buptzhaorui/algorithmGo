package company;

import java.util.Scanner;

public class Main4 {
  static double expect = 0.0;

  static class Node {
    int lastP;
    int curP;
    int flag;
    int level;
    int step;
    double totalP = 1.0d;
    Node left;
    Node right;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int P = sc.nextInt();
    int Q = sc.nextInt();
    int N = sc.nextInt();

    Node root = new Node();
    dfs(root, P, Q, N);

    String rst = String.format("%.2f", expect);
    System.out.println(rst);
  }

  static void dfs(Node root, int P, int Q, int N) {
    if (root != null) {
      if (root.level == N) {
        expect += root.step * root.totalP;
        return;
      }

      if (root.flag == 0) {
        root.curP = P;
      } else if(root.flag == 1) {
        root.curP = (int) Math.floor(P / (1 << root.level));
      } else {
        root.curP = (root.lastP + Q) >= 100 ? 100 : (root.lastP + Q);
      }

      if (root.curP > 0) {
        Node left = new Node();
        left.flag = 1;
        left.lastP = root.curP;
        left.level = root.level + 1;
        left.step = root.step + 1;
        left.totalP = (root.curP * root.totalP) / 100;
        root.left = left;
      }

      if (root.curP < 100) {
        Node right = new Node();
        right.flag = -1;
        right.lastP =  root.curP;
        right.level = root.level;
        right.step = root.step + 1;
        right.totalP = (root.totalP * (100 - root.curP) / 100);
        root.right = right;
      }
    }
    if (root.left != null) {
      dfs(root.left, P, Q, N);
    }
    if (root.right != null) {
      dfs(root.right, P, Q, N);
    }
  }
}
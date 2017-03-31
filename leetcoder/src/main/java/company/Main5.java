package company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main5 {
  static int counter = 0;

  static int[] dp(String s) {
    int n = s.length();
    if (n == 0) return null;
    int[] dp = new int[n];
    char[] arr = s.toCharArray();

    dp[0] = 0;

    for (int i = 1; i < n; ++i) {
      if (arr[i] == '(') {
        dp[i] = 0;
      } else if (arr[i] == ')' && i - dp[i - 1] - 1 >= 0 && arr[(i - dp[i - 1] - 1)] == '(') {
        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
      } else {
        dp[i] = 0;
      }
    }

    return dp;
  }

  static void dfs(ArrayList<Integer> list, ArrayList<Integer> spaces, int index, int l) {
    if(spaces.size() == index) {
      counter++;
    } else {
      int r = l;
      while(r <= list.get(index)) {
        dfs(list, spaces, index + 1, r);
        r++;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      String s = scanner.nextLine();
      int[] dp = dp(s);
      List<String> temp = new ArrayList<>();
      for (int i = dp.length - 1; i >= 0; --i) {
        if (dp[i] == 0) {
          temp.add("r");
        } else {
          int j = i - dp[i] + 1;
          temp.add("cmplx");
          i = j;
        }
      }

      ArrayList<Integer> list = new ArrayList<>();
      ArrayList<Integer> spaces = new ArrayList<>();
      for (int i = temp.size() - 1; i >= 0; --i) {
        if (temp.get(i).equals("r")) {
          list.add(temp.size() - 1 - i);
        }
        spaces.add(temp.size() - 1 - i);
      }
      dfs(list, spaces, 0, 0);
      System.out.println(list.size()+" "+counter);
    }
  }
}

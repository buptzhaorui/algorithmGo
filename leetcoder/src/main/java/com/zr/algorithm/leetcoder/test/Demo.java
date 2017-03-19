package com.zr.algorithm.leetcoder.test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: zhaorui
 * Date: 2017/3/14
 * Time: 11:08
 */
public class Demo {
  HashMap<Integer, Integer> map = new HashMap<>();
  Stack<Character> stack = new Stack<>();

  public void test() throws InterruptedException {
    synchronized (this){
      wait();

    }
  }
}

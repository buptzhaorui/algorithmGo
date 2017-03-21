package com.zr.algorithm.leetcoder.test;

/**
 * User: zhaorui
 * Date: 2017/3/21
 * Time: 12:47
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
  static class Task { //producer
    int num;
    int time; //处理完成时间
    Task(int num, int time){
      this.num = num;
      this.time = time;
    }
  }

  static class ServerInfo { //consumer
    int num; //任务数量
    int time; //任务预计完成时间
    ServerInfo(int num, int time){
      this.num = num;
      this.time = time;
    }
  }

  public static void main(String[] args)  {
    Scanner in = new Scanner(System.in);
    int maxQps= Integer.valueOf(in.nextLine());
    final String[] rtList = in.nextLine().split(",");
    final int requestNum = Integer.valueOf(in.nextLine());
    final int threadNum = Integer.valueOf(in.nextLine());
    System.out.println(doneTime(maxQps, rtList, requestNum, threadNum));
  }
  /**
   * 如果使用最优的最大吞吐量负载均衡算法，按照最优模型多久能够处理完所有请求，单位毫秒。
   * @return
   */
  static long doneTime(int maxQps,String[] rtList,int requestNum,int threadNum) {
    int len = rtList.length;
    int[] rts = new int[len];
    for(int i = 0; i < len; i++){
      rts[i] = Integer.valueOf(rtList[i]);
    }
    Arrays.sort(rts);
    int[] rtsQps = new int[len];
    for(int i = 0; i < len; i++){
      rtsQps[i] = maxQps;
    }

    long rst = 0;
    //生产者队列
    PriorityQueue<Task> taskQueue = new PriorityQueue<>((t1, t2) -> t1.time - t2.time);
    taskQueue.offer(new Task(threadNum, 0));

    //消费者队列
    LinkedList[] serverQueues = new LinkedList[len];
    for(int i = 0; i < len; i++){
      serverQueues[i] = new LinkedList<ServerInfo>();
    }

    while(requestNum > 0){
      Task task = taskQueue.poll();
      int idx = 0;

      while(idx < len && task.num > 0 && requestNum > 0){
        while(!serverQueues[idx].isEmpty()
          && ((ServerInfo)serverQueues[idx].getFirst()).time <= task.time - 1000){
          rtsQps[idx] += ((ServerInfo)serverQueues[idx].getFirst()).num;
          serverQueues[idx].pop();
        }

        if(rtsQps[idx] >= task.num){
          rtsQps[idx] -= task.num;
          requestNum -= task.num;
          serverQueues[idx].offer(new ServerInfo(task.num, task.time + rts[idx]));
          taskQueue.offer(new Task(task.num, task.time + rts[idx]));
          task.num = 0;
          rst = Math.max(rst, task.time + rts[idx]);
        } else if(rtsQps[idx] != 0){
          serverQueues[idx].offer(new ServerInfo(rtsQps[idx], task.time + rts[idx]));
          requestNum -= rtsQps[idx];
          rtsQps[idx] = 0;
          rst = Math.max(rst, task.time + rts[idx]);
        }

        idx++;
      }

      if(task.num > 0){
        task.time += 1;
        taskQueue.offer(task);
      }
    }
    return rst;
  }
}
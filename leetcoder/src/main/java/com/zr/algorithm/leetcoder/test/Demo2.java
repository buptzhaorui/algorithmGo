package com.zr.algorithm.leetcoder.test;

import java.util.*;

/**
 * User: zhaorui
 * Date: 2017/3/21
 * Time: 10:21
 */
class Task { //producer
  int num;
  int time; //处理完成时间
  Task(int num, int time){
    this.num = num;
    this.time = time;
  }
}

class ServerInfo { //consumer
  int num; //任务数量
  int time; //任务预计完成时间
  ServerInfo(int num, int time){
    this.num = num;
    this.time = time;
  }
}

public class Demo2 {
  long getRst(int maxQps, int[] rts, int reqNum, int threadNum) {
    int len = rts.length;
    Arrays.sort(rts);
    int[] rtsQps = new int[len];
    for(int i = 0; i < len; i++){
      rtsQps[i] = Math.min(1000 / rts[i], maxQps);
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

    while(reqNum > 0){
      Task task = taskQueue.poll();
      int idx = 0;

      while(idx < len && task.num > 0 && reqNum > 0){
        while(!serverQueues[idx].isEmpty()
          && ((ServerInfo)serverQueues[idx].getFirst()).time <= task.time - 1000){
          rtsQps[idx] += ((ServerInfo)serverQueues[idx].getFirst()).num;
          serverQueues[idx].pop();
        }

        if(rtsQps[idx] >= task.num){
          rtsQps[idx] -= task.num;
          reqNum -= task.num;
          serverQueues[idx].offer(new ServerInfo(task.num, task.time + rts[idx]));
          taskQueue.offer(new Task(task.num, task.time + rts[idx]));
          task.num = 0;
          rst = Math.max(rst, task.time + rts[idx]);
        } else if(rtsQps[idx] != 0){
          serverQueues[idx].offer(new ServerInfo(rtsQps[idx], task.time + rts[idx]));
          reqNum -= task.num;
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

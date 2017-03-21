package com.zr.algorithm.leetcoder.test;

import java.util.PriorityQueue;

/**
 * Created by zoujianlie on 2017/3/20.
 */
public class Demo3 {


  class Broker{
    double rt;//请求响应时间
    int qps;//最大qps
    double finishTime;//最近一次请求结束时间
    Broker(double rt, int qps){
      this.rt = rt;
      this.qps = qps;
      this.finishTime = 0;
    }
  }

  class Producer{
    double finishTime;//最近一次请求结束时间
  }

  /**
   *
   * @param qps broker qps
   * @param rts broker rt
   * @param threadNum 生产者线程数量
   * @param reqNum 任务总数
   * @return
   */
  public long getTime(int maxQps, String[] rtList, int threadNum, int reqNum){
    int[] rts = new int[rtList.length];
    for(int i = 0; i < rtList.length; i++){
      rts[i] = Integer.valueOf(rtList[i]);
    }

    PriorityQueue<Producer> producers = new PriorityQueue<>((o1,o2) -> o1.finishTime - o2.finishTime > 0 ? 1 : o1.finishTime - o2.finishTime == 0 ? 0 : -1);
    //init producers
    for(int i = 0; i < threadNum; ++i){
      producers.offer(new Producer());
    }
    PriorityQueue<Broker> brokers = new PriorityQueue<>((o1,o2) -> (o1.finishTime - o1.rt) - (o2.finishTime - o2.rt / 2) > 0 ? 1 : (o1.finishTime - o1.rt / 2) - (o2.finishTime - o2.rt / 2) == 0 ? 0 : -1);
    //init brokers
    for(int i = 0; i < rts.length; ++i){
      brokers.offer(new Broker(rts[i], maxQps));
    }

    double res = 0;
    while(reqNum-- > 0){

      Producer thread = producers.poll();

      Broker broker = brokers.poll();

      double startTime = Math.max(thread.finishTime, broker.finishTime - broker.rt / 2);//if the producer is ready to request, and the broker is ready to serve

      thread.finishTime = startTime + broker.rt;
      broker.finishTime = startTime + broker.rt / 2 + 1 / broker.qps;
      res = Math.max(res, broker.finishTime);
      producers.offer(thread);
      brokers.offer(broker);
    }

    return (long)res;
  }





}
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
  class Element{
    int num;
    int rt;
    Element(int num, int rt){
      this.num = num;
      this.rt = rt;
    }
  }

  class ElementCompare implements Comparator<Element> {


    @Override
    public int compare(Element o1, Element o2) {
      if(o1.num > QPS) return 1;
      if(o2.num > QPS) return -1;
      if (o1.num * o1.rt == o2.num * o2.rt) {
        return o1.rt > o2.rt ? 1 : o1.rt == o2.rt ? 0 : -1;
      }

      return o1.num * o1.rt > o2.num * o2.rt ? 1 : -1;
    }
  }

  int QPS;

  long getRst(int maxQps, int[] rts, int reqNum, int threadNum) {
    QPS = maxQps;
    Arrays.sort(rts);
    int validNum = Math.min(threadNum, rts.length);

    // 如果总请求数，大于一秒中能处理的请求总数，直接计算秒数
    long rst = reqNum / (maxQps * validNum) * 1000;
    reqNum = reqNum % (maxQps * validNum);

    // 建立小根堆，在堆顶的为下次返回时间最服务器
    PriorityQueue<Element> pq = new PriorityQueue<>(new ElementCompare());
    for (int i = 0; i < validNum; i++) {
      pq.add(new Element(0, rts[i]));
    }

    while (reqNum-- > 0) {
      // 取最小的返回时间的服务器，然后增加下一时间
      Element top = pq.poll();
      rst += top.rt;
      top.num += 1;
      pq.add(top);
    }

    return rst;
  }
}


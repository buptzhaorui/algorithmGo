package com.zr.algorithm.leetcoder.collection;

import java.util.*;

/**
 * User: zhaorui
 * Date: 2016/9/12
 * Time: 11:17
 */
public class Unmodifiable {
  public void printView(Map<String, String> m){
    Set<Map.Entry<String, String>> iter = m.entrySet();
    for( Map.Entry<String, String> entry: iter){
      System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
    }
  }
  public static void main(String[] s) {
    Unmodifiable demo = new Unmodifiable();
    //object hash table
    Hashtable<String,String> table = new Hashtable<>();

    // populate the table
    table.put("key1", "value1");
    table.put("key2", "value2");
    table.put("key3", "value3");

    System.out.println("Initial collection: "+table);

    // create unmodifiable map
    Map<String, String> m = Collections.unmodifiableMap(table);

    // try to modify the collection
//    m.put("key3", "value3");
    demo.printView(m);

    table.put("key4", "value4");

    demo.printView(m);

  }
}

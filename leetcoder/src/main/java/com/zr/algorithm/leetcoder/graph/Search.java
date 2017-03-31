package com.zr.algorithm.leetcoder.graph;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: zhaorui
 * Date: 2017/3/31
 * Time: 11:11
 */
public class Search {
  static class Node{
    String word;
    List<Edge> edges;
    Node(String word){
      this.word = word;
      this.edges = new ArrayList<Edge>();
    }
  }

  static class Edge{
    Node start;
    Node end;
    Edge(Node start, Node end){
      this.start = start;
      this.end = end;
    }
  }

  static void DFS(Node node, HashSet<Node> visited){
    if(!visited.contains(node)){
      System.out.println(node.word);
      visited.add(node);
      for(Edge edge: node.edges){
        DFS(edge.end, visited);
      }
    }
  }

  static void DFS2(Node node, HashSet<Node> visited){
    Stack<Node> stack = new Stack<>();
    stack.push(node);
    while(!stack.empty()){
      Node cur = stack.pop();
      if(!visited.contains(cur)){
        System.out.println(cur.word);
        visited.add(cur);
        for(Edge edge: cur.edges){
          stack.push(edge.end);
        }
      }
    }
  }

  static void BFS(Node node, HashSet<Node> visited){
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    while(!queue.isEmpty()){
      Node cur = queue.remove();
      if(!visited.contains(cur)){
        System.out.println(cur.word);
        visited.add(cur);
        queue.addAll(cur.edges.stream().map(edge -> edge.end).collect(Collectors.toList()));
      }
    }
  }

  public static void main(String[] args){
    Node A = new Node("A");
    Node B = new Node("B");
    Node C = new Node("C");
    Node D = new Node("D");
    Node E = new Node("E");
    Node F = new Node("F");
    Node G = new Node("G");

    A.edges.add(new Edge(A, B));
    A.edges.add(new Edge(A, C));
    A.edges.add(new Edge(A, F));
    B.edges.add(new Edge(B, A));
    B.edges.add(new Edge(B, G));
    C.edges.add(new Edge(C, D));
    D.edges.add(new Edge(D, B));
    D.edges.add(new Edge(D, E));
    D.edges.add(new Edge(D, F));
    E.edges.add(new Edge(E, G));
    G.edges.add(new Edge(G, B));
    G.edges.add(new Edge(G, E));

    BFS(A, new HashSet<>());

  }


}



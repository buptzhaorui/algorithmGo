package com.zr.algorithm.leetcoder.hashtable;

import java.util.*;

/**
 * User: zhaorui
 * Date: 2016/10/31
 * Time: 20:18
 */
public class Design355 {
  /**
   * Your Twitter object will be instantiated and called as such:
   * Twitter obj = new Twitter();
   * obj.postTweet(userId,tweetId);
   * List<Integer> param_2 = obj.getNewsFeed(userId);
   * obj.follow(followerId,followeeId);
   * obj.unfollow(followerId,followeeId);
   */
}

class Twitter {
  class Tweet {
    private Integer userId;
    private Integer tweetId;

    public Tweet(Integer userId, Integer tweetId) {
      this.userId = userId;
      this.tweetId = tweetId;
    }

    public Integer getTweetId() {
      return tweetId;
    }

    public Integer getUserId() {
      return userId;
    }

    public void setTweetId(Integer tweetId) {
      this.tweetId = tweetId;
    }

    public void setUserId(Integer userId) {
      this.userId = userId;
    }
  }
  private HashMap<Integer, HashSet<Integer>> followInfo;
  private ArrayList<Tweet> tweets;

  /** Initialize your data structure here. */
  public Twitter() {
    followInfo = new HashMap<>();
    tweets = new ArrayList<>();
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    tweets.add(0, new Tweet(userId, tweetId));
  }

  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  public List<Integer> getNewsFeed(int userId) {
    int counter = 0;
    HashSet<Integer> set = followInfo.get(userId);
    List<Integer> rst = new ArrayList<>();

    for(Tweet tweet: tweets){
      if(counter < 10){
        if(tweet.getUserId() == userId || (set != null && set.contains(tweet.getUserId()))){
          rst.add(tweet.getTweetId());
          counter ++;
        }
      }else{
        break;
      }
    }

    return rst;
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
    HashSet<Integer> set = followInfo.get(followerId);
    if(set == null){
      HashSet<Integer> newSet = new HashSet<>();
      newSet.add(followeeId);
      followInfo.put(followerId, newSet);
    }else{
      set.add(followeeId);
      followInfo.put(followerId, set);
    }
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
    HashSet<Integer> set = followInfo.get(followerId);
    if(set != null && set.contains(followeeId)){
      set.remove(followeeId);
      followInfo.put(followerId, set);
    }
  }
}

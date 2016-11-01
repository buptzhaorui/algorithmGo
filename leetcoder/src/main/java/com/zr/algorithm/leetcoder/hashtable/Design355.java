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


class Twitter2 {
  private static int timeStamp=0;

  // easy to find if user exist
  private Map<Integer, User> userMap;

  // Tweet link to next Tweet so that we can save a lot of time
  // when we execute getNewsFeed(userId)
  private class Tweet{
    public int id;
    public int time;
    public Tweet next;

    public Tweet(int id){
      this.id = id;
      time = timeStamp++;
      next=null;
    }
  }


  // OO design so User can follow, unfollow and post itself
  public class User{
    public int id;
    public Set<Integer> followed;
    public Tweet tweet_head;

    public User(int id){
      this.id=id;
      followed = new HashSet<>();
      follow(id); // first follow itself
      tweet_head = null;
    }

    public void follow(int id){
      followed.add(id);
    }

    public void unfollow(int id){
      followed.remove(id);
    }


    // everytime user post a new tweet, add it to the head of tweet list.
    public void post(int id){
      Tweet t = new Tweet(id);
      t.next=tweet_head;
      tweet_head=t;
    }
  }




  /** Initialize your data structure here. */
  public Twitter2() {
    userMap = new HashMap<Integer, User>();
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    if(!userMap.containsKey(userId)){
      User u = new User(userId);
      userMap.put(userId, u);
    }
    userMap.get(userId).post(tweetId);

  }



  // Best part of this.
  // first get all tweets lists from one user including itself and all people it followed.
  // Second add all heads into a max heap. Every time we poll a tweet with
  // largest time stamp from the heap, then we add its next tweet into the heap.
  // So after adding all heads we only need to add 9 tweets at most into this
  // heap before we get the 10 most recent tweet.
  public List<Integer> getNewsFeed(int userId) {
    List<Integer> res = new LinkedList<>();

    if(!userMap.containsKey(userId))   return res;

    Set<Integer> users = userMap.get(userId).followed;
    PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(users.size(), (a,b)->(b.time-a.time));
    for(int user: users){
      Tweet t = userMap.get(user).tweet_head;
      // very imporant! If we add null to the head we are screwed.
      if(t!=null){
        q.add(t);
      }
    }
    int n=0;
    while(!q.isEmpty() && n<10){
      Tweet t = q.poll();
      res.add(t.id);
      n++;
      if(t.next!=null)
        q.add(t.next);
    }

    return res;

  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
    if(!userMap.containsKey(followerId)){
      User u = new User(followerId);
      userMap.put(followerId, u);
    }
    if(!userMap.containsKey(followeeId)){
      User u = new User(followeeId);
      userMap.put(followeeId, u);
    }
    userMap.get(followerId).follow(followeeId);
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
    if(!userMap.containsKey(followerId) || followerId==followeeId)
      return;
    userMap.get(followerId).unfollow(followeeId);
  }
}


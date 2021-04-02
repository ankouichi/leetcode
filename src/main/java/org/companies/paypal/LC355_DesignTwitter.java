package org.companies.paypal;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user,
 * and is able to see the 10 most recent tweets in the user's news feed.
 *
 * Implement the Twitter class:
 *
 *     Twitter() Initializes your twitter object.
 *     void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId.
 *     Each call to this function will be made with a unique tweetId.
 *     List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed.
 *     Each item in the news feed must be posted by users who the user followed or by the user themself.
 *     Tweets must be ordered from most recent to least recent.
 *     void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
 *     void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
 *
 *     Constraints:
 *
 *     1 <= userId, followerId, followeeId <= 500
 *     0 <= tweetId <= 104
 *     All the tweets have unique IDs.
 *     At most 3 * 10^4 calls will be made to postTweet, getNewsFeed, follow, and unfollow.
 */
public class LC355_DesignTwitter {
    public class Tweet {
        int tweetId;
        LocalDateTime time;
        public Tweet(int id) {
            this.tweetId = id;
            this.time = LocalDateTime.now();
        }
    }

    Map<Integer, List<Integer>> following;
    Map<Integer, List<Tweet>> tweets;

    /** Initialize your data structure here. */
    public LC355_DesignTwitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId);
        List<Tweet> tweetList = tweets.getOrDefault(userId, new ArrayList<>());
        tweetList.add(tweet);
        tweets.put(userId, tweetList);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> myTweets = tweets.getOrDefault(userId, new ArrayList<>());
        List<Tweet> feeds = new ArrayList<>(myTweets);
        List<Integer> myFollowees = following.getOrDefault(userId, new ArrayList<>());
        for (Integer followee : myFollowees) {
            feeds.addAll(tweets.getOrDefault(followee, new ArrayList<>()));
        }

        Comparator<Tweet> tweetComparator = (t1, t2) -> t2.time.compareTo(t1.time);
        List<Integer> result = feeds.stream().sorted(tweetComparator).map(t -> t.tweetId).collect(Collectors.toList());

        return result.size() > 10 ? result.subList(0,10) : result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        List<Integer> followees = following.getOrDefault(followerId, new ArrayList<>());
        if (!followees.contains(followeeId)) {
            followees.add(followeeId);
            following.put(followerId, followees);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        List<Integer> followees = following.getOrDefault(followerId, new ArrayList<>());
        int idx = followees.indexOf(followeeId);
        if (idx > -1) {
            followees.remove(idx);
            following.put(followerId, followees);
        }
    }
}

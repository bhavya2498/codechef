// Problem: Design Twitter
// Platform: leetcode
// Rating/Difficulty: Medium
// Language: java
// Verdict: Accepted
// URL: https://leetcode.com/problems/design-twitter/
// Solved on: 2026-11-03T16:08:22.765Z


import java.util.*;

class Twitter {

    class Tweet {
        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    Map<Integer, Set<Integer>> following;
    Map<Integer, Tweet> tweets;
    int time;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId, time++);

        newTweet.next = tweets.get(userId);
        tweets.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq =
            new PriorityQueue<>((a, b) -> b.time - a.time);

        Set<Integer> users = new HashSet<>();

        users.add(userId);

        if (following.containsKey(userId)) {
            users.addAll(following.get(userId));
        }

        for (int user : users) {
            if (tweets.containsKey(user)) {
                pq.offer(tweets.get(user));
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty() && result.size() < 10) {

            Tweet current = pq.poll();

            result.add(current.tweetId);

            if (current.next != null) {
                pq.offer(current.next);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        following.putIfAbsent(followerId, new HashSet<>());

        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}

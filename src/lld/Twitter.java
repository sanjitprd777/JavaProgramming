package lld;

import java.util.*;

/* Design an in-memory version of twitter */

/*

Requirements:
1. User can Tweet
3. User can follow-unfollow another user
4. User Feed

NFR:
2. Users can Like or Comment a tweet
5. Users can do direct messaging
6. Re-tweet

Description:
=> User Feed
- User should see tweets made by their followees (expected)
- User should see tweets made by pages they follow (ignored)
Ordering:
- Popular user tweets appears at top
- Pages tweets appears after users tweets (ignored)
- Tweets are ordered by created date. (expected)

To implement:
- Users should see tweets made by their followees (expected)
- Tweets are ordered by created date. (expected)

Modeling:
Entities:
User
Tweet

Functionalities:
UserService
    - getUserFeed(user, ...)
        - fetch followees
        - fetch tweets
        - filtering/ordering of a tweet
        - return list of tweets
    - addFollowers(User follower, User followee...)
        - add(user)
    - addFollowee(...)
    - removeFollowers(...)

TweetService (UserFeedService obj)
    - createTweet(user, text, ...)
        - Create a tweet obj
        - Update user's tweet list
*/

// Driver class should be named 'Solution' and should not be public.
public class Twitter {

    static class User {
        public String id;
        public String username;

        HashSet<User> followers;
        HashSet<User> followees;
        List<Tweet> tweets;

        public User(String userId, String username) {
            this.id = userId;
            this.username = username;
            followees = new HashSet<User>();
            followers = new HashSet<User>();
            tweets = new ArrayList<>();
        }
    }

    static class Tweet {
        public String id;
        public String description;
        public User user;
        long timestamp;

        public Tweet(String tweetId, String description, User user) {
            this.id = tweetId;
            this.description = description;
            this.user = user;
            this.timestamp = System.currentTimeMillis();
        }
    }

    static interface UserService {
        List<Tweet> getUserFeed(User user);
        void addFollower(User follower, User followee);
        // void addFollowee(User follower, User followee);
        void removeFollower(User follower, User followee);
    }

    static class UserServiceImpl implements UserService {

        public List<Tweet> getUserFeed(User user) {
            HashSet<User> followees = user.followees;

            List<Tweet> tweets = user.tweets;

            for (User u : followees) {
                for (Tweet tweet : u.tweets) {
                    tweets.add(tweet);
                }
            }

            // Orderding of tweets;
            Collections.sort(tweets, (tweet1, tweet2) -> {
                if (tweet1.timestamp <= tweet2.timestamp)
                    return 1;
                return -1;
            });

            return tweets;
        }

        public void addFollower(User follower, User followee) {
            followee.followees.add(follower);
            follower.followers.add(followee);
        }

        public void removeFollower(User follower, User followee) {
            followee.followees.remove(follower);
            follower.followers.remove(followee);
        }
    }

    static interface TweetService {
        void createTweet(User user, String description);
    }

    static class TweetServiceImpl implements TweetService {

        @Override
        public void createTweet(User user, String description) {
            Tweet tweet = new Tweet("random-uuid", description, user);
            user.tweets.add(tweet);
        }
    }


    public static void main(String[] args) {
        User user1 = new User("1", "Sanjit");
        User user2 = new User("2", "Sanjit2");
        User user3 = new User("3", "Sanjit3");

        UserServiceImpl userService = new UserServiceImpl();
        TweetServiceImpl tweetService = new TweetServiceImpl();

        userService.addFollower(user1, user2);
        userService.addFollower(user1, user3);

        tweetService.createTweet(user2, "Sanjit2 make a tweet!!!");

        List<Tweet> tweets = userService.getUserFeed(user2);
        for (Tweet tweet : tweets) {
            System.out.println(tweet.id + " : " + tweet.description + " : " + tweet.timestamp);
        }


        List<Tweet> tweets1 = userService.getUserFeed(user1);
        for (Tweet tweet : tweets1) {
            System.out.println(tweet.id + " : " + tweet.description + " : " + tweet.timestamp);
        }

        System.out.println();

        tweetService.createTweet(user3, "Sanjit3 make a tweet!!!");

        List<Tweet> tweets3 = userService.getUserFeed(user3);
        for (Tweet tweet : tweets3) {
            System.out.println(tweet.id + " : " + tweet.description + " : " + tweet.timestamp);
        }


        List<Tweet> tweets2 = userService.getUserFeed(user1);
        for (Tweet tweet : tweets2) {
            System.out.println(tweet.id + " : " + tweet.description + " : " + tweet.timestamp);
        }
    }
}

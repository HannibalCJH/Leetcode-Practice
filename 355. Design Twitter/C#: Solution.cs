class Tweet
{
    public int tweetId;
    public int timePost;
    public Tweet(int Id, int time)
    {
        this.tweetId = Id;
        this.timePost = time;
    }
}

class TweetComparer : IComparer<Tweet>
{
    public int Compare(Tweet twt1, Tweet twt2)
    {
        return twt1.timePost - twt2.timePost;
    }
}

public class Twitter {
    int timeStamp;
    int maxFeedNum;
    Dictionary<int, HashSet<int>> followees;
    Dictionary<int, LinkedList<Tweet>> tweets;
    
    
    /** Initialize your data structure here. */
    public Twitter() 
    {
        timeStamp = 0;
        maxFeedNum = 10;
        followees = new Dictionary<int, HashSet<int>>();
        tweets = new Dictionary<int, LinkedList<Tweet>>();
    }
    
    /** Compose a new tweet. */
    public void PostTweet(int userId, int tweetId) 
    {
        if(!tweets.ContainsKey(userId))
        {
            tweets.Add(userId, new LinkedList<Tweet>());
            Follow(userId, userId);
        }
        tweets[userId].AddFirst(new Tweet(tweetId, timeStamp++));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public IList<int> GetNewsFeed(int userId) 
    {
        int count = 0;
        // 时间戳不会重复，一个时间戳只能发一条tweet，所以可以用SortedSet
        SortedSet<Tweet> feed = new SortedSet<Tweet>(new TweetComparer());
        IList<int> myFeed = new List<int>();
        // 用户没有followee
        if(!followees.ContainsKey(userId))
            return myFeed;
        foreach(int followeeId in followees[userId])
        {
            // 这个followee没有发过tweet
            if(!tweets.ContainsKey(followeeId))
                continue;
            foreach(Tweet twt in tweets[followeeId])
            {
                if(feed.Count < maxFeedNum)
                    feed.Add(twt);
                else
                {
                    if(twt.timePost < feed.Min.timePost)
                        break;
                    else
                    {
                        feed.Add(twt);
                        // 移除最早的tweet
                        feed.Remove(feed.Min);
                    }
                }
            }
        }
        
        while(feed.Count > 0)
        {
            // 等于Java的PriorityQueue分了两步走
            // 输出要求从最新的开始，所以用Max
            myFeed.Add(feed.Max.tweetId);
            // 删掉这个Max
            feed.Remove(feed.Max);
        }
        return myFeed;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void Follow(int followerId, int followeeId) 
    {
        if(!followees.ContainsKey(followerId))
            followees.Add(followerId, new HashSet<int>());
        
        if(!followees[followerId].Contains(followeeId))
            followees[followerId].Add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void Unfollow(int followerId, int followeeId) 
    {
        if(!followees.ContainsKey(followerId) || !followees[followerId].Contains(followeeId) || followerId == followeeId)
            return;
        followees[followerId].Remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.PostTweet(userId,tweetId);
 * IList<int> param_2 = obj.GetNewsFeed(userId);
 * obj.Follow(followerId,followeeId);
 * obj.Unfollow(followerId,followeeId);
 */

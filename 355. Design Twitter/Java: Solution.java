class Tweet
{
    int tweetId;
    int timePosted;
    public Tweet(int tId, int time)
    {
        tweetId = tId;
        timePosted = time;
    }
}

public class Twitter {
    // 时间戳，用static，所有类的实例共享一个时间戳防止时间重复
    static int timeStamp;
    // 一次性查找的最近feeds的数量，按题意为10
    int feedMaxNum;
    // 记录一个用户follow的其他用户
    HashMap<Integer, Set<Integer>> followees;
    // 记录所有用户发过的tweets，用双向链表方便头尾操作
    HashMap<Integer, LinkedList<Tweet>> tweets;
    
    /** Initialize your data structure here. */
    public Twitter() 
    {
        // 初始化数据
        timeStamp = 0;
        feedMaxNum = 10;
        followees = new HashMap<Integer, Set<Integer>>();
        tweets = new HashMap<Integer, LinkedList<Tweet>>();
    }
    
    // 时间复杂度O(1)，空间复杂度O(nk)
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) 
    {
        // 当前用户还没有发过tweets
        if(!tweets.containsKey(userId)) 
        {
            // 创建这个用户的键
            tweets.put(userId, new LinkedList<Tweet>());
            // 第一次自己发tweet，记得follow自己
            follow(userId, userId);
        }
        LinkedList<Tweet> twts = tweets.get(userId);
        // 把新的tweet加到表头，时间戳加1
        twts.addFirst(new Tweet(tweetId, timeStamp++));
        // 这一步不是必须的，如果考虑tweets过多会造成存储问题，那我们每次最多只存用户10条tweets就够，
        // 因为最极端情况是用户没有followee，这样他最新的10条feed都是他自己的，而且就这10条足够，多余的删除即可
        if(twts.size() > feedMaxNum)
            twts.removeLast();
    }
    
    // 时间复杂度O(nklogk)，n为平均一个用户拥有的followee，k为我们一次getNewsFeed返回多少feed，按题意是10
    // 空间复杂度O(nk)
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) 
    {
        // 根据tweet的时间戳进行排序，堆顶为最早的tweet
        PriorityQueue<Tweet> feedHeap = new PriorityQueue<Tweet>(new Comparator<Tweet>(){
            public int compare(Tweet t1, Tweet t2){
                return t1.timePosted - t2.timePosted;
            }
        });
    
        List<Integer> myFeed = new LinkedList<Integer>();
        // 这个用户没有followee
        if(!followees.containsKey(userId))
            return myFeed;

        // 遍历每个followee
        for(int followeeId : followees.get(userId))
        {
            // 这个followee没发过tweets
            if(!tweets.containsKey(followeeId))
                continue;
            for(Tweet twt : tweets.get(followeeId))
            {
                // feed堆还没达到最大额度直接把这条tweet加入堆
                if(feedHeap.size() < feedMaxNum) 
                    feedHeap.offer(twt);
                else
                {
                    // 这条tweet比堆顶即堆中最早的tweet还要早就跳出循环，因为链表中的tweet的排序是最新的在最前面，
                    // 所以这条tweet后面的tweets肯定时间戳都比当前这条还要早，没必要再往下找
                    if(twt.timePosted <= feedHeap.peek().timePosted) 
                        break;
                    else
                    {
                        // 加入这条tweet
                        feedHeap.offer(twt);
                        // 把最早的tweet删除
                        feedHeap.poll();
                    }
                }
            }
        }
        
        // 把所有堆中的tweets加入myFeed中，因为堆中的tweets是按照时间戳从早到晚排序，
        // 而我们输出的是从最新开始，所以每次插入到第一个位置
        while(!feedHeap.isEmpty())
        {
            myFeed.add(0, feedHeap.poll().tweetId);
        }
        return myFeed;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) 
    {
        // 不加入重复的followee
        if(!followees.containsKey(followerId)) 
            followees.put(followerId, new HashSet<Integer>());
        followees.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) 
    {
        // 不能删除自己本身
        if(!followees.containsKey(followerId) || !followees.get(followerId).contains(followeeId) || followerId == followeeId) 
            return;
        followees.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */

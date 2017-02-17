/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    // 贪心算法
    // 时间复杂度nlog(n)，空间复杂度O(n)
    public int minMeetingRooms(Interval[] intervals) 
    {
        if(intervals == null || intervals.length == 0)
            return 0;
        
        // 按照会议开始时间排序，这样可以保证每次都找离当前时间段结束时间最近的时间段
        Arrays.sort(intervals, new Comparator<Interval>()
        {
            public int compare(Interval int1, Interval int2)
            {
                return int1.start - int2.start;
            }
        });
        
        // 优先队列用来记录每个房间最晚的结束时间，寻找所有房间最早的结束时间为log(n)
        PriorityQueue<Integer> endTimes = new PriorityQueue<Integer>();
        endTimes.offer(0);
        for(int i = 0; i < intervals.length; i++)
        {
            // 查看所有房间里最早的结束时间
            // 如果当前时间段的开始时间比所有房间最早的结束时间晚，就把这个时间段加入这个房间
            // 即把该房间当前的结束时间拿掉(poll)，替换成当前时间段的结束时间(offer)
            if(intervals[i].start >= endTimes.peek())
                endTimes.poll();
            // 如果当前时间段的开始时间比所有房间最早的结束时间都要早，那就直接开辟新的房间把当前时间段的结束时间加入队列
            endTimes.offer(intervals[i].end);
        }
        return endTimes.size();
    }
}

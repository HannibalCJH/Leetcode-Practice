/**
 * Definition for an interval.
 * public class Interval {
 *     public int start;
 *     public int end;
 *     public Interval() { start = 0; end = 0; }
 *     public Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    // 贪心算法
    // 时间复杂度O(nlogn)
    public int MinMeetingRooms(Interval[] intervals) 
    {
        if(intervals == null || intervals.Length == 0)
            return 0;
            
        // 按照会议开始时间排序，这样可以保证每次都找离当前时间段结束时间最近的时间段
        Array.Sort(intervals, new IntervalComparer());
        
        // List用来记录每个房间最晚的结束时间，寻找所有房间最早的结束时间为O(n)
        List<int> endTimes = new List<int>();
        endTimes.Add(0);
        
        for(int i = 0; i < intervals.Length; i++)
        {
            // 所有房间中最早的结束时间
            int min = FindEarliestEndTime(endTimes);
            // 如果当前时间段的开始时间比所有房间最早的结束时间晚，就把这个时间段加入这个房间
            // 即把该房间当前的结束时间拿掉(poll)，替换成当前时间段的结束时间(offer)
            if(intervals[i].start >= min)
                endTimes.Remove(min);
            // 如果当前时间段的开始时间比所有房间最早的结束时间都要早，那就直接开辟新的房间把当前时间段的结束时间加入队列
            endTimes.Add(intervals[i].end);
        }
        return endTimes.Count;
    }
    
    // 寻找所有房间中最早的结束时间
    private int FindEarliestEndTime(List<int> endTimes)
    {
        int min = int.MaxValue;
        foreach(int endTime in endTimes)
        {
            min = Math.Min(endTime, min);
        }
        return min;
    }
    
    class IntervalComparer : IComparer<Interval>
    {
        public int Compare(Interval int1, Interval int2)
        {
            return int1.start - int2.start;
        }
    }
}

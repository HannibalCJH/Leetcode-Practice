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
    // 时间复杂度nlog(n)，空间复杂度O(1)
    public boolean canAttendMeetings(Interval[] intervals) 
    {
        if(intervals == null || intervals.length == 0)
            return true;
        
        // 根据开始时间排序
        Arrays.sort(intervals, new Comparator<Interval>()
        {
            public int compare(Interval int1, Interval int2)
            {
                return int1.start - int2.start;
            }
        });
        
        // 设置一个最晚结束时间
        int lastEnd = 0;
        for(int i = 0; i < intervals.length; i++)
        {
            Interval current = intervals[i];
            // 当前时间段开始时间比最晚结束时间早
            if(current.start < lastEnd)
                return false;
            // 更新最晚结束时间
            lastEnd = Math.max(current.end, lastEnd);
        }
        return true;
    }
}

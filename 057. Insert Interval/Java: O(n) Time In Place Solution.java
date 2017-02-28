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
    // In Place
    // 时间复杂度O(n)，空间复杂度O(1)
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) 
    {
        int index = 0;
        // 结束时间比待插入的区间小的直接加入跳过
        while(index < intervals.size() && intervals.get(index).end < newInterval.start)
        {
            index++;
        }
        // 把和待插入区间有重叠的其他区间一起合并成一个区间
        while(index < intervals.size() && intervals.get(index).start <= newInterval.end)
        {
            newInterval = new Interval(Math.min(intervals.get(index).start, newInterval.start), 
                                        Math.max(intervals.get(index).end, newInterval.end));
            // 删除这个有重叠的区间
            intervals.remove(index);
        }
        // 加入这个合并后的区间
        intervals.add(index, newInterval);
        return intervals;
    }
}

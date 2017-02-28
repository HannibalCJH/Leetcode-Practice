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
    public IList<Interval> Insert(IList<Interval> intervals, Interval newInterval) 
    {
        // IList不能用Insert所以先用List复制列表
        List<Interval> newIntervals = new List<Interval>(intervals);
        int index = 0;
        while(index < newIntervals.Count && newIntervals[index].end < newInterval.start)
        {
            index++;
        }
        
        while(index < newIntervals.Count && newIntervals[index].start <= newInterval.end)
        {
            newInterval = new Interval(Math.Min(newIntervals[index].start, newInterval.start),
                                        Math.Max(newIntervals[index].end, newInterval.end));
            newIntervals.RemoveAt(index);
        }
        newIntervals.Insert(index, newInterval);
        return newIntervals;
    }
}

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
        IList<Interval> result = new List<Interval>();
        int index = 0;
        while(index < intervals.Count && intervals[index].end < newInterval.start)
        {
            result.Add(intervals[index++]);
        }
        
        while(index < intervals.Count && intervals[index].start <= newInterval.end)
        {
            newInterval = new Interval(Math.Min(intervals[index].start, newInterval.start),
                                        Math.Max(intervals[index].end, newInterval.end));
            index++;
        }
        result.Add(newInterval);
        while(index < intervals.Count)
        {
            result.Add(intervals[index++]);
        }
        return result;
    }
}

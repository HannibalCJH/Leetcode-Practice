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
    public IList<Interval> Merge(IList<Interval> intervals) 
    {
        if(intervals == null || intervals.Count == 0)
            return new List<Interval>();
        
        List<Interval> result = new List<Interval>();
        int length = intervals.Count;
        // IList不支持Sort，重新用List创建，用数组也可以
        List<Interval> newIntervals = new List<Interval>(intervals);
        // 按照开始时间排序
        newIntervals.Sort(new IntervalComparer());
        Interval current = newIntervals[0];
        Interval next;
        for(int i = 1; i < length; i++)
        {
            next = newIntervals[i];
            if(current.end < next.start)
            {
                result.Add(current);
                current = next;
            }
            else
                current.end = Math.Max(current.end, next.end);
        }
        result.Add(current);
        return result;
    }
    
    class IntervalComparer : IComparer<Interval>
    {
        public int Compare(Interval int1, Interval int2)
        {
            return int1.start - int2.start;
        }
    }
}

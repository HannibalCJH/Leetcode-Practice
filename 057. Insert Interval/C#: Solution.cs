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
        if(intervals == null)
            return new List<Interval>();
        
        // 把newInterval插入intervals，不过IList不支持Sort所以重新创建一个List
        List<Interval> result = new List<Interval>();
        List<Interval> newIntervals = new List<Interval>(intervals);
        newIntervals.Add(newInterval);
        newIntervals.Sort(new IntervalComparer());
        
        Interval current = newIntervals[0];
        Interval next;
        for(int i = 1; i < newIntervals.Count; i++)
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

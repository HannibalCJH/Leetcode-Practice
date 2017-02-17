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
    public bool CanAttendMeetings(Interval[] intervals) 
    {
        if(intervals == null || intervals.Length == 0)
            return true;
            
        Array.Sort(intervals, new IntervalComparer());
        int lastEnd = 0;
        for(int i = 0; i < intervals.Length; i++)
        {
            Interval current = intervals[i];
            if(current.start < lastEnd)
                return false;
            lastEnd = Math.Max(current.end, lastEnd);
        }
        return true;
    }
    
    class IntervalComparer : IComparer<Interval>
    {
        public int Compare(Interval int1, Interval int2)
        {
            return int1.start - int2.start;
        }
    }
}

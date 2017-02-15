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
        List<Interval> intervalList = new List<Interval>(intervals);
        intervalList.Add(newInterval);
        intervalList.Sort(new IntervalComparer());
        
        Interval pre = intervalList[0];
        for(int i = 1; i < intervalList.Count; i++)
        {
            Interval cur = intervalList[i];
            if(cur.start > pre.end)
            {
                pre = cur;
            }
            else
            {
                pre.end = pre.end < cur.end ? cur.end : pre.end;
                intervalList.RemoveAt(i--);
            }
        }
        return intervalList;
    }
    
    class IntervalComparer : IComparer<Interval>
    {
        public int Compare(Interval int1, Interval int2)
        {
            return int1.start - int2.start;
        }
    }
}

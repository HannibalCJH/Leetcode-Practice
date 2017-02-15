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
    // 时间复杂度nlog(n)，空间复杂度O(n)
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) 
    {
        if(intervals == null)
            return new ArrayList<Interval>();
        
        List<Interval> result = new ArrayList<Interval>();
        int length = intervals.size();
        // 新建数组，把newInterval放到数组最后并对整个数组以开始时间进行排序
        Interval[] intervalArray = new Interval[length + 1];
        for(int i = 0; i < length; i++)
            intervalArray[i] = intervals.get(i);
        intervalArray[length] = newInterval;
        Arrays.sort(intervalArray, new Comparator<Interval>()
        {
            public int compare(Interval int1, Interval int2)
            {
                return int1.start - int2.start;
            }
        });
        
        Interval current = intervalArray[0];
        Interval next;
        for(int i = 1; i < length + 1; i++)
        {
            next = intervalArray[i];
            if(current.end < next.start)
            {
                result.add(current);
                current = next;
            }
            else
                current.end = Math.max(current.end, next.end);
        }
        result.add(current);
        return result;
    }
}

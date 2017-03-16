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
    // 时间复杂度O(nlog(n))，主要是排序花时间
    // 空间复杂度O(n)
    public List<Interval> merge(List<Interval> intervals) 
    {
        if(intervals == null || intervals.size() == 0)
            return new ArrayList<Interval>();
        
        List<Interval> result = new ArrayList<Interval>();
        // 转换成数组，有利于排序
        int length = intervals.size();
        Interval[] intervalArray = new Interval[length];
        for(int i = 0; i < length; i++)
            intervalArray[i] = intervals.get(i);
        // 根据开始时间排序
        Arrays.sort(intervalArray, new Comparator<Interval>()
        {
            public int compare(Interval int1, Interval int2)
            {
                return int1.start - int2.start;
            }
        });
        
        Interval current = intervalArray[0];
        Interval next;
        for(int i = 1; i < length; i++)
        {
            next = intervalArray[i];
            // 两个时间段不重叠
            if(current.end < next.start)
            {
                result.add(current);
                current = next;
            }
            else
                current.end = Math.max(current.end, next.end);
        }
        // 最后一个时间段没有在for循环中加入
        result.add(current);
        return result;
    }
}

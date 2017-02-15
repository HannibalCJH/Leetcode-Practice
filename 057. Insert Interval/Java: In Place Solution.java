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
    // In place直接在原链表上操作
    // 实际复杂度O(n^2)，主要是remove某个位置的元素时会把之后的所有元素往前移动耗时O(n)
    // 空间复杂度O(1)
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) 
    {
        // 插入新的时间段
        intervals.add(newInterval);
        // 按照开始时间排序
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval int1, Interval int2)
            {
                return int1.start - int2.start;
            }
        });
        
        Interval pre = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++)
        {
            Interval cur = intervals.get(i);
            if(cur.start > pre.end)
            {
                pre = cur;
            }
            else
            {
                pre.end = pre.end < cur.end ? cur.end : pre.end;
                // i要减1，所有之后的元素都会往前移动一个位置所以本来i+1的元素移动到了i的位置
                intervals.remove(i--);
            }
        }
        return intervals;
    }
}

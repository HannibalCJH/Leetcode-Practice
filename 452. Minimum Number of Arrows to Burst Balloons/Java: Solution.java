public class Solution {
    // 类似Course Schedule II，但要求越重叠越好
    // 时间复杂度O(nlogn)，空间复杂度O(1)
    public int findMinArrowShots(int[][] points) 
    {
        if(points == null || points.length == 0 || points[0].length == 0)
            return 0;
        
        // 按照起点排序，起点排序相同按照终点排序
        Arrays.sort(points, new Comparator<int[]>(){
            public int compare(int[] pt1, int[] pt2)
            {
                if(pt1[0] == pt2[0])
                    return pt1[1] - pt2[1];
                else
                    return pt1[0] - pt2[0];
            }
        });
        
        // 第一箭，肯定要射中第一个气球
        int count = 1;
        // 箭最多能平移的位置为第一个气球的终点，我们要保证第一个气球能被射中
        int arrowRange = points[0][1];
        for(int i = 1; i < points.length; i++)
        {
            // 这个气球的起点依然在上一支箭的射程范围内
            if(points[i][0] <= arrowRange)
            {
                // 更新射程范围，要保证能射中第i个气球，当arrowRange大于第i个气球的终点会造成可能会射不中的情况
                // 所以这个时候就要更新为第i个气球的终点
                arrowRange = Math.min(arrowRange, points[i][1]);
            }
            else
            {
                // 这个气球的起点已经超过了上一支箭的射程范围，需要另外再射一支箭了
                count++;
                // 设这支新的箭的射程范围为第i个气球的终点
                arrowRange = points[i][1];
            }
        }
        return count;
    }
}

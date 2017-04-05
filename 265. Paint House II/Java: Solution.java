public class Solution {
    // 时间复杂度O(nk)，n为房子数，k为颜色数
    public int minCostII(int[][] costs) 
    {
        if(costs == null || costs.length == 0 || costs[0].length == 0) 
            return 0;
        // 记录上一幢房子最小的和次小的cost，preIdx记录上一幢房子用的颜色
        // 初始化min1和min2为0，这样做计算第0幢房子时costs[i][j]就是它自己，因为不管选min1还是min2都是0
        int min1 = 0, min2 = 0, preIdx = -1;
        // 遍历每一幢房子
        for(int i = 0; i < costs.length; i++)
        {
            // 记录这一幢房子最小的和次小的cost，curIdx记录这一幢房子最小cost的颜色
            int cur1 = Integer.MAX_VALUE, cur2 = Integer.MAX_VALUE, curIdx = -1;
            for(int j = 0; j < costs[0].length; j++)
            {
                // 利用原来的数组来做动规数组，如果用的颜色和上一幢最小cost的颜色一样，为了避免相邻房子颜色重复，选次小的cost
                costs[i][j] = costs[i][j] + (j == preIdx ? min2 : min1);
                // 找出这一幢房子最小和次小的cost，最小的要记录下标，方便下一轮判断
                if(costs[i][j] < cur1)
                {
                    cur2 = cur1;
                    cur1 = costs[i][j];
                    curIdx = j;
                } 
                else if(costs[i][j] < cur2)
                {
                    cur2 = costs[i][j];
                }
            }
            // 把这一幢的计算结果记录下来
            min1 = cur1;
            min2 = cur2;
            preIdx = curIdx;
        }
        // 最后一幢房子最小的cost
        return min1;    
    }
}

public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public int minCost(int[][] costs) 
    {
        if(costs == null || costs.length == 0 || costs[0].length == 0)
            return 0;
        
        int n = costs.length;
        // 直接在原数组上计算，节省空间
        for(int i = 1; i < n; i++)
        {
            // 涂第一种颜色的话，上一个房子就不能涂第一种颜色，这样我们要在上一个房子的第二和第三个颜色的最小开销中找最小的那个加上
            costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);
            // 涂第二或者第三种颜色同理
            costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i - 1][1]);
        }
        // 返回涂三种颜色中开销最小的那个
        return Math.min(Math.min(costs[n - 1][0], costs[n - 1][1]), costs[n - 1][2]);
    }
}

public class Solution {
	// 动态规划，从终点往上搜索
	// 时间复杂度O(mn)，空间复杂度O(mn)
	public int calculateMinimumHP(int[][] dungeon) 
	{
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];
        
        // 计算最后一格
        dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
    
        // 初始化最后一列
        for(int i = m - 2; i >= 0; i--)
        	dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        
        // 初始化最后一行
        for(int j = n - 2; j >= 0; j--) 
        	dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);

        // 搜索其他
        for(int i = m - 2; i >= 0; i--) 
        	for(int j = n - 2; j >= 0; j--) 
        		// 选择当前元素下边和右边所需生命的较小值
        		dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1);
        	
        return dp[0][0];
    }
}

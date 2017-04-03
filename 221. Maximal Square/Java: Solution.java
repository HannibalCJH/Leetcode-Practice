public class Solution {
    // 动态规划，参考博文https://segmentfault.com/a/1190000003709497
    // 时间复杂度O(mn)，空间复杂度O(mn)
    public int maximalSquare(char[][] matrix) 
    {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        int[][] dp = new int[m][n];
        // 初始化第一行
        for(int i = 0; i < n; i++)
        {
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(dp[0][i], max);
        }
        // 初始化第一列
        for(int i = 0; i < m; i++)
        {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(dp[i][0], max);
        }
        // 递推
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                if(matrix[i][j] == '1')
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                max = Math.max(dp[i][j], max);
            }
        }
        // 返回的是面积
        return max * max;
    }
}

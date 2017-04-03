public class Solution {
    public int MaximalSquare(char[,] matrix) 
    {
        if(matrix == null || matrix.GetLength(0) == 0 || matrix.GetLength(1) == 0)
            return 0;
            
        int m = matrix.GetLength(0), n = matrix.GetLength(1);
        int max = 0;
        int[,] dp = new int[m, n];
        // 初始化第一行
        for(int i = 0; i < n; i++)
        {
            dp[0, i] = matrix[0, i] - '0';
            max = Math.Max(dp[0, i], max);
        }
        // 初始化第一列
        for(int i = 0; i < m; i++)
        {
            dp[i, 0] = matrix[i, 0] - '0';
            max = Math.Max(dp[i, 0], max);
        }
        // 递推
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                if(matrix[i, j] == '1')
                    dp[i, j] = Math.Min(Math.Min(dp[i - 1, j], dp[i, j - 1]), dp[i - 1, j - 1]) + 1;
                max = Math.Max(dp[i, j], max);
            }
        }
        return max * max;
    }
}

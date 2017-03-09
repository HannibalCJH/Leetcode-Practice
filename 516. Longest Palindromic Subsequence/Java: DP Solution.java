public class Solution {
    // 参考http://www.xuebuyuan.com/2158451.html的表格解释，非常有助于理解
    // 时间复杂度O(n^2)，空间复杂度O(n^2)
    public int longestPalindromeSubseq(String s) 
    {
        int n = s.length();
        // dp[i][j]表示从i到j位置的子串中最长的回文子序列长度
        int[][] dp = new int[n][n];
        // 根据所给链接里的表格，我们决定dp[i][j]是根据左下格，左边或者下边的格子，很明显我们应该先构建完下一行才能构建当前的行，
        // 所以我们采取自底向上的构建方法，根据转移方程我们也可以看出，我们需要先完成i+1行的构建才能递推回第i行
        for(int i = n - 1; i >= 0; i--)
        {
            // 初始化一个字符的情况
            dp[i][i] = 1;
            for(int j = i + 1; j < n; j++)
            {
                // 首尾两个字符相同，那就是被首尾夹着的子串的最大回文子序列长度加2，很好理解，
                // 就是i+1到j-1位置的最大回文子序列长度加上首尾相同两个字符
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    // 当首尾字符不相同，我们要不选择包括进首字符，要不就选择包括进末尾字符，选长度大的就行
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        // 返回从0到n-1也就是整个字符串范围下的最大回文子序列的长度
        return dp[0][n - 1];
    }
}

public class Solution {
    public bool IsMatch(string s, string p) 
    {
        int m = s.Length, n = p.Length;
        bool[,] dp = new bool[m + 1, n + 1];
        // s和p都是空字符串
        dp[0, 0] = true;
        // p为空字符串
        for(int i = 1; i <= m; i++)
        {
            dp[i, 0] = false;
        }
        // s为空字符串
        for(int j = 1; j <= n; j++)
        {
            if(p[j - 1] == '*')
                dp[0, j] = true;
            else
                break;
        }
        
        for(int i = 1; i <= m; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(p[j - 1] != '*')
                    dp[i, j] = dp[i - 1, j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == '?');
                else
                    dp[i, j] = dp[i, j - 1] || dp[i - 1, j];
            }
        }
        return dp[m, n];
    }
}

public class Solution {
    public bool IsMatch(string s, string p) 
    {
        if(s == null || p == null)
            return false;
        
        bool[,] dp = new bool[s.Length + 1, p.Length + 1];
        dp[0, 0] = true;
        for(int i = 1; i < p.Length + 1; i++)
        {
            if(p[i - 1] == '*')
            {
                if(i == 1 || (i > 1 && dp[0, i - 2]))
                {
                    dp[0, i] = true;
                }
            }
        }
        
        for(int i = 1; i < s.Length + 1; i++)
        {
            for(int j = 1; j < p.Length + 1; j++)
            {
                if(s[i - 1] == p[j - 1] || p[j - 1] == '.')
                    dp[i, j] = dp[i - 1, j - 1];
                
                if(p[j - 1] == '*')
                {
                    if(s[i - 1] != p[j - 2] && p[j - 2] != '.')
                    {
                        dp[i, j] = dp[i, j - 2];
                    }
                    else
                    {
                        dp[i, j] = dp[i - 1, j] || dp[i, j - 1] || dp[i, j - 2];
                    }
                }
            }
        }
        return dp[s.Length, p.Length];
    }
}

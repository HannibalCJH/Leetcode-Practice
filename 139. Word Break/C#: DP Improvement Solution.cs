public class Solution {
    public bool WordBreak(string s, IList<string> wordDict) 
    {
        bool[] dp = new bool[s.Length + 1];
        dp[0] = true;
        int maxLength = GetMaxLength(wordDict);
        for(int i = 1; i < s.Length + 1; i++)
        {
            dp[i] = false;
            for(int j = (i - maxLength) > 0 ? i - maxLength : 0; j < i; j++)
            {
                if(dp[j] && wordDict.Contains(s.Substring(j, i - j)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.Length];
    }
    
    private int GetMaxLength(IList<string> wordDict)
    {
        int maxLength = 0;
        foreach(string word in wordDict)
        {
            maxLength = Math.Max(word.Length, maxLength);
        }
        return maxLength;
    }
}

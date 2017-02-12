public class Solution {
    // 时间复杂度O(nm)，n指字符串长度，m指最长单词长度
    // 空间复杂度O(n)，dp数组
    public boolean wordBreak(String s, List<String> wordDict) 
    {
        // dp[i]表示前i个字符能被完美切分，这里i从1开始
        boolean[] dp = new boolean[s.length() + 1];
        // 前零个字符，也就是空字符为true
        dp[0] = true;
        // 最长单词的长度
        int maxLength = getMaxLength(wordDict);
        // 分割
        for(int i = 1; i < s.length() + 1; i++)
        {
            // 初始化为false
            dp[i] = false;
            // 看前j个字符
            // 如果i大于最长单词长度，那j就没有必要从0开始检查，因为0到i超过了最长单词的长度所以肯定无法构成一个单词
            for(int j = (i - maxLength) > 0 ? i - maxLength : 0; j < i; j++)
            {
                // 前j个字符能被完美切分且j+1到i的字符串是词典里的单词
                // 这里注意下标的对应，dp[i]表示的前i个是从1开始，而字符串s下标从0开始
                if(dp[j] && wordDict.contains(s.substring(j, i)))
                {
                    dp[i] = true;
                    // 找到一个完美切分即可
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
    private int getMaxLength(List<String> wordDict)
    {
        int maxLength = 0;
        for(String word : wordDict)
        {
            maxLength = Math.max(word.length(), maxLength);
        }
        return maxLength;
    }
}

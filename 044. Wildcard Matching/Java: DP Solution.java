public class Solution {
    // 时间复杂度O(mn)，空间复杂度O(mn)
    public boolean isMatch(String s, String p) 
    { 
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
    	// 两个空字符相匹配
    	dp[0][0] = true;
    	// 初始化p为空字符串的情况，s中的每个字符和p都匹配
    	// 因为数组默认元素初始的值为false，所以其实可以省去这个for循环
    	for(int i = 1; i <= m; i++)
    	{
    	    dp[i][0] = false;
    	}
    	// 初始化s为空字符串的情况
    	// 1. 检查p从第一个字符开始又连续的几个'*'来匹配，因为'*'可以匹配空字符串，比如"*****abc"
    	// 2. 碰到第一个不为'*'的字符就跳出循环
        for(int j = 1; j <= n; j++)
        {
            if(p.charAt(j - 1) == '*')
                dp[0][j] = true;
            else
                break;
        }
        
    	// 两个字符串都不是空字符串，尝试匹配
    	for(int i = 1; i <= m; i++)
    	{
    	    for(int j = 1; j <= n; j++)
    	    {
    		    // p的字符不是'*'，那就必须要求
    		    // 1. s和p之前的字符都匹配
    		    // 2. s和p的字符刚好对应或者p的字符是单字符通配符'?'
    		    if(p.charAt(j - 1) != '*')
    		        dp[i][j] = dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
                else
    			    // dp[i][j - 1]: 省略当前'*'，即'*'匹配一个空字符
    			    // dp[i - 1][j]: '*'匹配当前字符
    			    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
    	    }
    	}
    	return dp[m][n];
    }
}

public class Solution {
    // 动态规划，遍历一遍字符串，时间复杂度O(n)
    // 空间复杂度O(n)
    public int numDecodings(String s) 
    {
        // 第一个数字为0则没有解法
        if(s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        
        // dp[i]表示从头到第i个字符有几种解法，这里i从下标1开始
        int[] dp = new int[s.length() + 1];
        // 初始化dp数组
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= s.length(); i++)
        {
            // 如果第i-1和i位数字在10到26的范围内，则可以在i-2位的基础上解码
            // 注意字符串的位置从1开始，不是数组的0，所以i-1和i应该表示成数组的i-2和i-1位
            if(Integer.parseInt(s.substring(i - 2, i)) >= 10 && Integer.parseInt(s.substring(i - 2, i)) <= 26)
                dp[i] += dp[i-2];
            // 如果第i-1和i位数字不在10到26的范围内，则只能在i-1位的基础上解码
            if(Integer.parseInt(s.substring(i - 1, i)) > 0)
                dp[i] += dp[i-1];
        }
        return dp[s.length()];
    }
}

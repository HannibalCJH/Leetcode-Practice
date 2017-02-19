public class Solution {
    // 动态规划
    // 时间复杂度O(n)，空间复杂度O(n)
    public int maxSubArray(int[] nums) 
    {
        if(nums == null || nums.length == 0)
            return 0;
        // 记录包括nums[i]在内的最大子序列和
        int[] dp = new int[nums.length];
        // 初始化
        dp[0] = nums[0];
        int max = dp[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            // 如果dp[i-1]是负数，那还不如不要，nums[i]自己重新开始作为一个子序列的开头
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}

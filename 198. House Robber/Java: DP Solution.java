public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public int rob(int[] nums) 
    {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        // 初始化前面两个房子的情况
        // 记录前i个房子能盗取的最大金额
        int[] dp = new int[nums.length];
        // 第一个房子最大的金额
        dp[0] = nums[0];
        // 第二个房子最大的金额
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++)
        {
            // 最大的金额可以是前i-2个房子的最大金额加上第i个房子也可以是前i-1个房子的金额
            // 也就是是否盗取当前房子钱的选择
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        
        return dp[nums.length - 1];
    }
}

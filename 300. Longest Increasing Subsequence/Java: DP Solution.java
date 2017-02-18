public class Solution {
    // 时间复杂度O(n^2)，空间复杂度O(n)
    public int lengthOfLIS(int[] nums) 
    {
        if(nums == null || nums.length == 0)
            return 0;
        
        // nums不为空的情况下全局最大是1，因为只要有一个数它本身就可以被认为是一个LIS
        int max = 1;
        // dp[i]表示加入nums[i]后从0到i能形成的包括nums[i]的LIS
        int[] dp = new int[nums.length];
        dp[0] = 1;
        // 计算dp[i]
        for(int i = 1; i < nums.length; i++)
        {
            // 先初始化为1，因为这个元素本身就是一个长度
            dp[i] = 1;
            // 寻找所有之前比nums[j]小的元素，并计算dp[i]的最大值
            for(int j = 0; j < i; j++)
            {
                // 这些比nums[i]小的元素的dp[j]中保存的是从0到j之间以nums[j]结尾的LIS
                // 所以dp[j] + 1表示在dp[j]表示的LIS后加上nums[i]形成新的长度加1的LIS
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}

public class Solution {
    public int MaxSubArray(int[] nums) 
    {
        if(nums == null || nums.Length == 0)
            return 0;
            
        int[] dp = new int[nums.Length];
        dp[0] = nums[0];
        int max = dp[0];
        
        for(int i = 1; i < nums.Length; i++)
        {
            dp[i] = Math.Max(dp[i - 1] + nums[i], nums[i]);
            max = Math.Max(dp[i], max);
        }
        return max;
    }
}

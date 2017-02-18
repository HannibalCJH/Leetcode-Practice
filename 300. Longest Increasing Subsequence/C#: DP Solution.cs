public class Solution {
    public int LengthOfLIS(int[] nums) 
    {
        if(nums == null || nums.Length == 0)    
            return 0;
        int maxLength = 1;
        int[] dp = new int[nums.Length];
        dp[0] = 1;
        for(int i = 1; i < nums.Length; i++)
        {
            dp[i] = 1;
            for(int j = 0; j < i; j++)
            {
                if(nums[j] < nums[i])
                    dp[i] = Math.Max(dp[i], dp[j] + 1);
            }
            maxLength = Math.Max(maxLength, dp[i]);
        }
        return maxLength;
    }
}

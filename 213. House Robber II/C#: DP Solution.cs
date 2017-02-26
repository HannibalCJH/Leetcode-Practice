public class Solution {
    public int Rob(int[] nums) 
    {
        return Math.Max(RobHelper(nums, 0), RobHelper(nums, 1));    
    }
    
    private int RobHelper(int[] nums, int offset)
    {
        if(nums.Length == 0)
            return 0;
        if(nums.Length == 1)
            return nums[0];
        if(nums.Length == 2)
            return offset == 0 ? nums[0] : nums[1];
        
        int[] dp = new int[nums.Length];
        dp[offset] = nums[offset];
        dp[offset + 1] = Math.Max(nums[offset], nums[offset + 1]);
        for(int i = offset + 2; i < nums.Length - 1 + offset; i++)
        {
            dp[i] = Math.Max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.Length - 2 + offset];
    }
}

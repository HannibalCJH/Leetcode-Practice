public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public int rob(int[] nums) 
    {
        return Math.max(robHelper(nums, 0), robHelper(nums, 1));    
    }
    // offset表示数组从哪个位置开始，0的话就不盗取最后一个房子，1的话盗取最后一个房子
    private int robHelper(int[] nums, int offset)
    {
        // 数组长度过小直接返回
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return offset == 0 ? nums[0] : nums[1];
        int[] dp = new int[nums.length];
        dp[offset] = nums[offset];
        dp[offset + 1] = Math.max(nums[offset], nums[offset + 1]);
        for(int i = offset + 2; i < nums.length - 1 + offset; i++)
        {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 2 + offset];
    }
}

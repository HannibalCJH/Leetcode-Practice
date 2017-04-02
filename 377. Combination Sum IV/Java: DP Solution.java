public class Solution {
    // 动态规划
    // 时间复杂度O(target*n)，空间复杂度O(target)
    public int combinationSum4(int[] nums, int target) 
    {
        // dp数组用来记录元素和为i的子数组的个数
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i < target + 1; i++) 
        {
            for(int j = 0; j < nums.length; j++) 
            {
                // i比nums[j]大，我们就加上和为i-nums[j]的子数组个数
                // 其实比较容易理解，比如i为4，nums[j]为1，那我们还需要的差为4-1=3，
                // 既然我们选定了其中一个加数为nums[j]，那我们就看另一个加数即和为3的组合有几个就行
                if(i >= nums[j])
                    dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}

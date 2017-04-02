public class Solution {
    // 时间复杂度O(2^n)，空间复杂度O(n)，递归栈空间
    int count = 0;
    
    public int findTargetSumWays(int[] nums, int S) 
    {
        if(nums == null || nums.length == 0)
            return count;
        
        dfs(nums, S, 0, 0);
        return count;
    }
    
    private void dfs(int[] nums, int S, int sum, int step)
    {
        if(step == nums.length)
        {
            if(sum == S)
                count++;
            return;
        }
        // 加号
        dfs(nums, S, sum + nums[step], step + 1);
        // 减号
        dfs(nums, S, sum - nums[step], step + 1);
    }
}

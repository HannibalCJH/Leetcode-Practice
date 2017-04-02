public class Solution {
    int count = 0;
    
    public int FindTargetSumWays(int[] nums, int S) 
    {
        if(nums == null || nums.Length == 0)
            return count;
        
        DFS(nums, S, 0, 0);
        return count;
    }
    
    private void DFS(int[] nums, int S, int sum, int step)
    {
        if(step == nums.Length)
        {
            if(sum == S)
                count++;
            return;
        }
        
        DFS(nums, S, sum + nums[step], step + 1);
        DFS(nums, S, sum - nums[step], step + 1);
    }
}

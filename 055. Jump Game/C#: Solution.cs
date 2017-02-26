public class Solution {
    public bool CanJump(int[] nums) 
    {
        if(nums.Length < 2)
            return true;
            
        int maxReach = 0;
        for(int i = 0; i < nums.Length; i++)
            if(i <= maxReach)
                maxReach = Math.Max(maxReach, i + nums[i]);
        return maxReach >= nums.Length - 1;
    }
}

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
            
        int first = 0, second = 0;
        for(int i = offset; i < nums.Length - 1 + offset; i++)
        {
            int cur = Math.Max(first + nums[i], second);
            first = second;
            second = cur;
        }
        return second;
    }
}

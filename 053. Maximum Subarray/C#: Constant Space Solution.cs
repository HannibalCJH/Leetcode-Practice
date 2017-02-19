public class Solution {
    public int MaxSubArray(int[] nums) 
    {
        if(nums == null || nums.Length == 0)
            return 0;
            
        int temp = nums[0];
        int max = temp;
        
        for(int i = 1; i < nums.Length; i++)
        {
            temp = Math.Max(temp + nums[i], nums[i]);
            max = Math.Max(temp, max);
        }
        return max;
    }
}

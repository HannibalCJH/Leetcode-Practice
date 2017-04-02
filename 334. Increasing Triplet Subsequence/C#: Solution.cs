public class Solution {
    public bool IncreasingTriplet(int[] nums) 
    {
        if(nums == null || nums.Length < 3)
            return false;
        
        int first = Int32.MaxValue, second = Int32.MaxValue;
        for(int i = 0; i < nums.Length; i++)
        {
            if(nums[i] <= first)
                first = nums[i];
            else if(nums[i] <= second)
                second = nums[i];
            else
                return true;
        }
        return false;
    }
}

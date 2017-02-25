public class Solution {
    public int FindPeakElement(int[] nums) 
    {
        if(nums == null || nums.Length < 2)
            return 0;
        for(int i = 1; i < nums.Length - 1; i++)
        {
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;
        }
        return nums[0] > nums[1] ? 0 : nums.Length - 1;
    }
}

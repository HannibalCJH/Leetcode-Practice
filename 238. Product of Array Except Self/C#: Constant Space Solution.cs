public class Solution {
    public int[] ProductExceptSelf(int[] nums) 
    {
        if(nums == null || nums.Length == 0)
            return nums;
        
        int length = nums.Length;
        int[] result = new int[length];
        result[0] = 1;
        for(int i = 1; i < length; i++)
        {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        int right = 1;
        for(int i = length - 2; i >= 0; i--)
        {
            right *= nums[i + 1];
            result[i] = result[i] * right;
        }
        return result;
    }
}

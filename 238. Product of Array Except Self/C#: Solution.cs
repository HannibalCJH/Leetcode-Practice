public class Solution {
    public int[] ProductExceptSelf(int[] nums) 
    {
        if(nums == null || nums.Length == 0)
            return nums;
        
        int length = nums.Length;
        int[] backward = new int[length];
        int[] result = new int[length];
        
        result[0] = 1;
        for(int i = 1; i < length; i++)
        {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        backward[length - 1] = 1;
        for(int i = length - 2; i >= 0; i--)
        {
            backward[i] = backward[i + 1] * nums[i + 1];
        }
        
        for(int i = 0; i < length; i++)
        {
            result[i] *= backward[i];
        }
        
        return result;
    }
}

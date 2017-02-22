public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public int[] productExceptSelf(int[] nums) 
    {
        if(nums == null || nums.length == 0)
            return nums;
        
        int length = nums.length;
        int[] result = new int[length];
        result[0] = 1;
        for(int i = 1; i < length; i++)
        {
            result[i] = result[i - 1] * nums[i - 1];
        }
        // 利用right来存nums[i]右边的乘积，每次累乘
        int right = 1;
        for(int i = length - 2; i >= 0; i--)
        {
            right *= nums[i + 1];
            result[i] = result[i] * right;
        }
        return result;
    }
}

public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public int[] productExceptSelf(int[] nums) 
    {
        if(nums == null || nums.length == 0)
            return nums;
        
        int length = nums.length;
        int[] backward = new int[length];
        int[] result = new int[length];
        
        // 数组错位正向乘一遍
        // 把每个元素向后移一位，这样数组中对应的元素是nums[i]左边元素的积
        result[0] = 1;
        for(int i = 1; i < length; i++)
        {
            result[i] = result[i - 1] * nums[i - 1];
        }
        // 数组错位反向乘一遍
        // 把每个元素向前移一位，这样数组中对应的元素是nums[i]右边元素的积
        backward[length - 1] = 1;
        for(int i = length - 2; i >= 0; i--)
        {
            backward[i] = backward[i + 1] * nums[i + 1];
        }
        // 把正向和反向的相应元素乘一下
        // nums[i]左边元素的积乘以右边元素的积，不包括自己
        for(int i = 0; i < length; i++)
        {
            result[i] *= backward[i];
        }
        return result;
    }
}

public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public void moveZeroes(int[] nums) 
    {
        int index = 0;
        // 0会被不断地交换到后面
        for(int i = 0; i < nums.length; i++) 
        {
            if(nums[i] != 0) 
            {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index++] = temp;
            }
        }
    }
}

public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public void rotate(int[] nums, int k) 
    {
        if(nums == null || nums.length == 0)
            return;
        // 反转整个数组
        int length = nums.length;
        swap(nums, 0, length - 1);
        // 分段反转
        int step = k % length;
        swap(nums, 0, step - 1);
        swap(nums, step, length - 1);
    }
    
    private void swap(int[] nums, int left, int right)
    {
        while(left < right)
        {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}

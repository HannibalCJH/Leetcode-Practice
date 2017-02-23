public class Solution {
    // 快速排序法
    // 平均时间复杂度O(n)，最坏情况O(n^2)
    // 空间复杂度O(1)
    public int findKthLargest(int[] nums, int k) 
    {
        return quickSelect(nums, k - 1, 0, nums.length - 1);
    }
    
    private int quickSelect(int[] nums, int k, int left, int right)
    {
        // 取中点的值
        int pivot = nums[(left + right) / 2];
        int start = left, end = right;
        while(start <= end)
        {
            // 从右向左找到第一个小于枢纽值的数
            while(nums[start] > pivot)
                start++;
            // 从左向右找到第一个大于枢纽值的数
            while(nums[end] < pivot)
                end--;
            // 将两个数互换
            if(start <= end)
            {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
        // 最后退出的情况应该是右指针在左指针左边一格
        // 这时如果右指针还大于等于k，说明kth在左半边
        if(left < end && k <= end) 
            return quickSelect(nums, k, left, end);
        // 这时如果左指针还小于等于k，说明kth在右半边
        if(start < right && k >= start) 
            return quickSelect(nums, k, start, right);
        return nums[k];
    }
    
    private void swap(int[] nums, int idx1, int idx2)
    {
        int temp = nums[idx1] + nums[idx2];
        nums[idx1] = temp - nums[idx1];
        nums[idx2] = temp - nums[idx2];
    }
}

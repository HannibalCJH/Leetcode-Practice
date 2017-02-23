public class Solution {
    // 思想和Search in rotated sorted array一模一样，维持一个全局最小，找到正常的半边然后更新全局最小值为正常半边的最小值
    // 接着去二分搜索不正常的半边
    // 时间复杂度O(logn)，空间复杂度O(1)
    public int findMin(int[] nums) 
    {
        int left = 0, right = nums.length - 1;
        int min = nums[0];
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            // 左半边的顺序正常
            if(nums[left] <= nums[mid])
            {
                // 根据左半边最小值nums[left]来更新全局min
                min = Math.min(min, nums[left]);
                // 轴心在右半边，去检查
                left = mid + 1;
            }
            else
            {
                // 右半边顺序正常
                // 根据右半边最小值nums[mid]来更新全局min
                min = Math.min(min, nums[mid]);
                // 轴心在左半边，去检查
                right = mid - 1;
            }
        }
        return min;
    }
}

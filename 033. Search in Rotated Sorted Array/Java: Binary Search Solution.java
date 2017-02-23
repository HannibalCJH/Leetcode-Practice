public class Solution {
    // 二分搜索
    // 时间复杂度O(logn)，空间复杂度O(1)
    public int search(int[] nums, int target) 
    {
        if(nums == null || nums.length == 0)
            return -1;
            
        int left = 0, right = nums.length - 1;
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            // 找到目标
            if(nums[mid] == target)
                return mid;
            // 左半边是正常顺序
            else if(nums[left] <= nums[mid])
            {
                // 判断target是不是落在顺序正常的左半边
                if(nums[left] <= target && nums[mid] > target)
                    right = mid - 1;
                else
                    // 如果不在左半边那只能在右半边
                    left = mid + 1;
            }
            // 左半边是不正常顺序
            else
            {
                // 判断target是不是落在顺序正常的右半边
                if(nums[right] >= target && target > nums[mid])
                    left = mid + 1;
                else
                    // 如果不在右半边那只能在左半边
                    right = mid - 1;
            }
        }
        return -1;
    }
}

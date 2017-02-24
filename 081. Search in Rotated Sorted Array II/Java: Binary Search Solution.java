
public class Solution {
    // 时间复杂度O(logn)，最坏情况O(n)
    // 空间复杂度O(1)
    public boolean search(int[] nums, int target) 
    {
        if(nums == null || nums.length == 0)
            return false;
            
        int left = 0, right = nums.length - 1;
        while(left <= right) 
        {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) 
                return true;
            // 左半边是正常顺序
            if(nums[left] < nums[mid]) 
            {
                if(nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            // 左半边是不正常顺序
            else if(nums[left] > nums[mid]) 
            {
                if(nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            // 当左边界和中间点一样，比如11131，这时两边都是有序的
            // 做法是让左边界往右移动
            else 
                left++;
        }
        return false;
    }
}

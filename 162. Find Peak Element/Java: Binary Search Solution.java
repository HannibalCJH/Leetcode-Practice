public class Solution {
    // 时间复杂度O(logn)，空间复杂度O(1)
    public int findPeakElement(int[] nums) 
    {
        int left = 0, right = nums.length - 1;
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            // 左右边界相邻
            if(left == mid)
                return nums[left] < nums[right] ? right : left;
            // 中点比右边小，则右边是上坡，抛弃左边
            if(nums[mid] < nums[mid + 1])
                left = mid;
            // 中点比右边大，则右边是下坡，抛弃右边
            if(nums[mid] > nums[mid + 1])
                right = mid;
        }
        return 0;
    }
}

public class Solution {
    public int FindPeakElement(int[] nums) 
    {
        int left = 0, right = nums.Length - 1;
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            // 左右指针相邻
            if(left == mid)
                return nums[left] < nums[right] ? right : left;
            if(nums[mid] < nums[mid + 1])
                left = mid;
            if(nums[mid] > nums[mid + 1])
                right = mid;
        }
        return 0;
    }
}

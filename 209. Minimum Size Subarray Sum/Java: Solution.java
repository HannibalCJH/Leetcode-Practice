public class Solution {
    // 思路同Minimum Window Substring，用滑动窗口
    // 时间复杂度O(n)，空间复杂度O(1)
    public int minSubArrayLen(int s, int[] nums) 
    {
        if(nums == null || nums.length == 0)    
            return 0;
        
        int left = 0, right = 0;
        int sum = 0, minLength = nums.length + 1;
        // 先移动右边界指针找到大于等于s的子数组，再移动左指针缩小这个滑动窗口
        while(right < nums.length)
        {
            sum += nums[right];
            while(sum >= s)
            {
                // 更新最小窗口长度
                minLength = Math.min(minLength, right - left + 1);
                // 左边界指针向前移动，缩小窗口
                sum -= nums[left++];
            }
            right++;
        }
        // 如果最小窗口的长度是nums.length + 1即初始值，则说明没有大于等于s的子数组
        return minLength == nums.length + 1 ? 0 : minLength;
    }
}

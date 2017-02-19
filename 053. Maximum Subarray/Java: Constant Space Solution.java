public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public int maxSubArray(int[] nums) 
    {
        if(nums == null || nums.length == 0)
            return 0;
        
        // 记录当前最大值
        int temp = nums[0];
        // 记录全局最大值
        int max = temp;
        
        for(int i = 1; i < nums.length; i++)
        {
            // 如果temp+nums[i]比nums[i]大，那nums[i]属于temp形成的子数组
            // 不然重新开始一个以nums[i]开头的子数组
            temp = Math.max(temp + nums[i], nums[i]);
            // 比较全局和当前最大值，如果当前的大则更新为全局最大值
            max = Math.max(temp, max);
        }
        return max;
    }
}

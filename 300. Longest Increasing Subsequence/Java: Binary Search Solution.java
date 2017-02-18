public class Solution {
    // 时间复杂度O(nlogn)，空间复杂度O(n)
    public int lengthOfLIS(int[] nums) 
    {
        if(nums == null || nums.length == 0)
            return 0;
            
        // len表示当前最长的升序序列长度（为了方便操作tails我们减1）
        int len = 0;
        // tails[i]表示长度为i的升序序列其末尾的数字
        int[] tails = new int[nums.length];
        tails[0] = nums[0];
        // 根据三种情况更新不同升序序列的集合
        for(int i = 1; i < nums.length; i++)
        {
            // 比最小的末尾数字还要小，直接更新长度为1的序列的末尾
            if(nums[i] < tails[0])
                tails[0] = nums[i];
            // 大于等于最大的末尾数字，说明有新的长度加1的序列产生，新开一个末尾
            else if(nums[i] > tails[len])
                tails[++len] = nums[i];
            else
                // 如果在中间，则二分搜索，找到末尾刚好大于等于nums[i]的末尾，更新这个末尾
                tails[binarySearch(tails, 0, len, nums[i])] = nums[i];
        }
        return len + 1;
    }
    
    private int binarySearch(int[] tails, int left, int right, int target)
    {
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            if(tails[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}

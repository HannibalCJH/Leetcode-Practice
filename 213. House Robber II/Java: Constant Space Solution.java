public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public int rob(int[] nums) 
    {
        return Math.max(robHelper(nums, 0), robHelper(nums, 1));    
    }
    // offset表示数组从哪个位置开始，0的话就不盗取最后一个房子，1的话盗取最后一个房子
    private int robHelper(int[] nums, int offset)
    {
        // 数组长度过小直接返回
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
            
        int first = 0, second = 0;
        for(int i = offset; i < nums.length - 1 + offset; i++)
        {
            int cur = Math.max(first + nums[i], second);
            first = second;
            second = cur;
        }
        return second;
    }
}

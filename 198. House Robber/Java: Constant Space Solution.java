public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public int rob(int[] nums) 
    {
        // 记录前面两种情况
        int first = 0, second = 0;
        for(int i = 0; i < nums.length; i++)
        {
            int cur = Math.max(first + nums[i], second);
            first = second;
            second = cur;
        }
        return second;
    }
}

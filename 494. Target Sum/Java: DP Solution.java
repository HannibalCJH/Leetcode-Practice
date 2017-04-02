public class Solution {
    // 动态规划，和Combination IV类似，只是这里因为和可能是负数，所以进行位移，
    // 比如对数组nums[1,1,1,1,1]，
    // dp数组下标0,1,2,3,4,5,6,7,8,9,10分别对应的sum为-5,-4,-3-2,-1,0,1,2,3,4,5
    // 时间复杂度O(n*sum)，sum为数组中所有元素的和
    // 空间复杂度O(sum)，sum为数组中所有元素的和
    public int findTargetSumWays(int[] nums, int S) 
    {
        int sum = 0;
        // 把所有的数加起来
        for(int i : nums) 
            sum += i;
        // S比所有数的和打或者比所有数的差小则没有组合可以得到S
        if(S > sum || S < -sum) 
            return 0;
        // dp数组，因为元素正负都有可能，所以是sum的两倍
        int[] dp = new int[2 * sum + 1];
        // 初始化和为0的情况，因为位移的关系，所以和为0的dp数组下标为0+sum
        dp[0 + sum] = 1;
        // 遍历数组中的每一个元素
        for(int i = 0; i < nums.length; i++)
        {
            // 因为每个元素只能取一次，所以每次都要重置next数组
            int[] next = new int[2 * sum + 1];
            // 每一个可能的和
            for(int j = 0; j < 2 * sum + 1; j++)
            {
                if(dp[j] != 0)
                {
                    // 一个加数为nums[i]，另一个加数j，计算和为j(+/-)nums[i]的个数
                    // 加号
                    next[j + nums[i]] += dp[j];
                    // 减号
                    next[j - nums[i]] += dp[j];
                }
            }
            dp = next;
        }
        // 和为0的下标为sum，所以和为S的下标就是sum+S
        return dp[sum + S];
    }
}

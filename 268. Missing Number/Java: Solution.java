public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public int missingNumber(int[] nums) 
    {
        int n = nums.length;
        // 高斯求和得到本来完整的和，注意是0~n共有n+1和数
        int sum = (0 + n) * (n + 1) / 2;
        int temp = 0;
        // 当前数组中的和，有缺数
        for(int num : nums)
        {
            temp += num;
        }
        // 相减就是缺的数
        return sum - temp;
    }
}

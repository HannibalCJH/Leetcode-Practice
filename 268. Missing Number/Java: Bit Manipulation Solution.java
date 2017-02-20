public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public int missingNumber(int[] nums) 
    {
        // 根据异或的特性，对于一个数，异或自己是0，异或0是自己，
        // 所以我们把0-n都异或一遍，再对着给定数组异或一遍，结果就是缺失的数
        // 自己用[0,1,2,4,5,6,7]试一遍就一目了然
        int missing = 0, i = 0;
        for(i = 0; i < nums.length; i++)
		    missing ^= i ^ nums[i];
        return missing ^ i;
    }
}

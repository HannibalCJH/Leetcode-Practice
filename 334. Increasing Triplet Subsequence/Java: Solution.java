public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public boolean increasingTriplet(int[] nums) 
    {
        if(nums == null || nums.length < 3)
            return false;
        
        // 用两个变量记录遍历时遇到的最小的两个符合顺序的数，注意这两个数要求nums[i] < nums[j]且满足顺序i < j，
        // 所以这两个数不一定是遍历过的部分中最小的两个数
        Integer first = null, second = null;
        for(int i = 0; i < nums.length; i++)
        {
            // 注意比较的顺序，同时也注意比较用的是小于等于而不是只有小于
            // 对于[1,1,1,1,1,1,1]这个例子，如果比较是用小于，那在第三个1会落到else条件里直接返回真，但是我们要的不同的数
            // 首先比较第一个也就是较小的那个数
            if(first == null || nums[i] <= first)
                first = nums[i];
            // 如果比较小的数大那就比较较大的数
            else if(second == null || nums[i] <= second)
                second = nums[i];
            else
                // 比两个数都大，说明有了第三个满足条件的数就返回真
                return true;
        }
        return false;
    }
}

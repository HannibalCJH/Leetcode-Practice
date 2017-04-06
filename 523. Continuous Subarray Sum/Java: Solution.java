public class Solution {
    // 思路类似Maximum Size Subarray Sum Equals k
    // 时间复杂度O(n)，空间复杂度O(k)
    public boolean checkSubarraySum(int[] nums, int k) 
    {
        // 哈希表键位从0到i位元素之和除以k的余数，值为下标i
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 初始一个sum为0，下标为-1的键值对
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            // 每次加上当前元素
            sum += nums[i];
            // 在k不为0的情况下，取除以k的余数
            if(k != 0)
                sum %= k;
            // 取余之前的和为k*m+sum，如果之前有sum，那这两个数的差就是k*m即k的m倍
            // 我们只要对两个数的下标相减就是子数组的长度
            // 1. 需要注意的是余数为sum的位置真正的和应该是k*n+sum，只是我们每次都是取余
            //    所以这段子数组应该是k(m-n)即k的(m-n)倍
            // 2. 注意上面的m-n可以是负数，所以是负的倍数也是符合题意的
            if(map.containsKey(sum))
            {
                if(i - map.get(sum) > 1)
                    return true;
            }
            else
            {
                // 为了尽量使得到的子数组长度比较长，我们只在哈希表中没有当前余数sum的情况下加入表中，
                // 即我们取相同余数中靠前的下标位置
                map.put(sum, i);
            }
        }
        return false;
    }
}

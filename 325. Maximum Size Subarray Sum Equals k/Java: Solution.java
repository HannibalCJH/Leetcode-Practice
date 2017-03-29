public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public int maxSubArrayLen(int[] nums, int k) 
    {
        // 哈希表键位从0到i位元素之和，值为下标i
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0, sum = 0;
        // 初始一个sum为0，下标为-1的键值对。
        // 如果不加这个初始条件，在[1, -1, 5, -2, 3]这个例子中，sum=0最早被存入的是在下标为1的位置，即前两个元素和为0
        // 最后得到的结果就会是[5, -2]而不是[1, -1, 5, -2]
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) 
        {
            // 每次加上当前元素
            sum += nums[i];
            // 从0到i元素之和为sum，假设从0到j元素之和为sum-k，其中j<=i。
            // 那么从j+1到i的元素的和就应该为k，所以长度就是i-j
            if(map.containsKey(sum - k)) 
                max = Math.max(i - map.get(sum - k), max);
            // 只有在当前的sum不存在时才加入哈希表，因为如果之前已经有这个sum在位置m，当前的为n，那在之后遇到找到一个子数组等于k时，
            // i-m肯定大于i-n
            if(!map.containsKey(sum)) 
                map.put(sum, i);
        }
        return max;
    }
}

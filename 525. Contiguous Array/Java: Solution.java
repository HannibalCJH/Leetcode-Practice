public class Solution {
    // 思路类似Maximum Size Subarray Sum Equals k
    // 时间复杂度O(n)，空间复杂度O(1)
    public int findMaxLength(int[] nums) 
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int count = 0, maxLength = 0;
        for(int i = 0; i < nums.length; i++)
        {
            // 用count记录0和1出现的相对次数，遇到1就加1，遇到0则减1
            count += (nums[i] == 1 ? 1 : -1);
            // 之前已经碰到过这个count了，那i位置对应的count和之前的位置的count一减，我们得到
            // 1. count - count = 0，也就是从上一个count的位置到现在的i位置之间0和1出现的次数是一样的
            // 2. 这段子数组的长度就是i-map.get(count)
            if(map.containsKey(count))
            {
                maxLength = Math.max(maxLength, i - map.get(count));
            }
            else
            {
                // 因为我们要找最长的子数组，那么就只需记录count第一次出现的位置就可以拉大和i之间的距离
                map.put(count, i);
            }
        }
        return maxLength;
    }
}

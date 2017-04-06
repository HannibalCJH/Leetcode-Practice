public class Solution {
    // 时间复杂度O(k)，k为数组长度
    public int totalHammingDistance(int[] nums) 
    {
        int length = nums.length;
        int n = 32;
        int[] bitmap = new int[n];
        // 遍历一遍所有的数，记录每个二进制位上1出现的总的次数
        for(int num : nums)
        {
            for(int i = 0; i < n; i++)
            {
                bitmap[i] += num & 1;
                num >>= 1;
            }
        }
        
        int count = 0;
        // 假设第0位即最右边的二进制位统计得到的数是i，也就是说nums中有i个数在这个二进制位上是1，
        // 那也可以得知nums中有length-i个数在这个位置上是0，
        // 要统计这个二进制位不同组合的个数，我们可以在一堆1中选一个，在一堆0中选一个，所以总共有i*(length-i)种组合，
        // 所以这个位置上的不同的数的组合为i*(length-i)，那接下来我们只要每个二进制位上统计一遍加起来就行
        for(int i = 0; i < n; i++)
        {
            count += bitmap[i] * (length - bitmap[i]);
        }
        return count;
    }
}

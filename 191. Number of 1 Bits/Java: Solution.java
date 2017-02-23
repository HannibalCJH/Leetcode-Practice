public class Solution {
    // 时间复杂度O(logn)，每次都是右移一位即除以2
    // 空间复杂度O(1)
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) 
    {
        int count = 0;
        // 不能用n > 0，因为当输入的是2147483648(1000000000000000)，java会认为是负数就不会进入while循环
        while(n != 0)
        {
            if((n & 1) == 1)
                count++;
            n >>>= 1;
        }
        return count;
    }
}

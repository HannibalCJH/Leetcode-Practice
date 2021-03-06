public class Solution {
    // 时间复杂度O(1)，空间复杂度O(1)
    public boolean isPowerOfFour(int num) 
    {
        // 判断条件:
        // 1. 排除负数，正数的幂肯定大于零
        // 2. 从二进制数来看，4的幂一定只有一个二进制位为1其余都为0。而4^n-1的肯定是末尾一串1的二进制数
        // 所以当n为4的幂时那么n & (n-1) 应该是0
        // 3. 0x55555555是16进制数，二进制即01010101...01010101，4的幂二进制中1所在的位置肯定是奇数为
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;    
    }
}

public class Solution {
    // 时间复杂度O(1)，空间复杂度O(1)
    public boolean isPowerOfTwo(int n) 
    {
        // 判断条件:
        // 1. 排除负数，正数的幂肯定大于零
        // 2. 从二进制数来看，2的幂一定只有一个二进制位为1其余都为0。而2^n-1的肯定是末尾一串1的二进制数
        // 所以当n为2的幂时那么n & (n-1) 应该是0，比如
        // n = 2 ^ 0 = 1 = 0b0000...00000001, and (n - 1) = 0 = 0b0000...0000
        // n = 2 ^ 1 = 2 = 0b0000...00000010, and (n - 1) = 1 = 0b0000...0001
        // n = 2 ^ 2 = 4 = 0b0000...00000100, and (n - 1) = 3 = 0b0000...0011
        // n = 2 ^ 3 = 8 = 0b0000...00001000, and (n - 1) = 7 = 0b0000...0111
        return n > 0 && (n & (n - 1)) == 0;    
    }
}

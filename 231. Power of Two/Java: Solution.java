public class Solution {
    // 时间复杂度O(logn)，空间复杂度O(1)
    public boolean isPowerOfTwo(int n) 
    {
        // 如果n很大，计算的power可能会超过最大整型数所以用long
        long power = 1;
        while(power < n)
        {
            power *= 2;
        }
        return (int)power == n;
    }
}

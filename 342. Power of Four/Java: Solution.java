public class Solution {
    // 时间复杂度O(logn)，空间复杂度O(1)
    public boolean isPowerOfFour(int num) 
    {
        // 如果num很大，计算的power可能会超过最大整型数所以用long
        long power = 1;
        while(power < num)
        {
            power *= 4;
        }
        return (int)power == num;
    }
}

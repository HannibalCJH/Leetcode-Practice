public class Solution {
    // 时间复杂度O(32)，空间复杂度O(1)
    public int hammingDistance(int x, int y) 
    {
        int count = 0;
        int xor = x ^ y;
        while(xor != 0)
        {
            count += (xor & 1);
            xor >>>= 1;
        }
        return count;
    }
}

public class Solution {
    public int HammingDistance(int x, int y) 
    {
        int count = 0;
        int xor = x ^ y;
        while(xor != 0)
        {
            count += (xor & 1);
            xor >>= 1;
        }
        return count;
    }
}

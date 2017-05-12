public class Solution {
    public bool IsPowerOfTwo(int n) 
    {
        long power = 1;
        while(power < n)
        {
            power *= 2;
        }
        return (int)power == n;
    }
}

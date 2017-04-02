public class Solution {
    public double MyPow(double x, int n) 
    {
        if(n == 0)
            return 1;
        if(n == Int32.MinValue)
        {
            x *= x;
            n /= 2;
        }
        
        if(n < 0)
        {
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? MyPow(x * x, n / 2) : x * MyPow(x * x, n / 2);
    }
}

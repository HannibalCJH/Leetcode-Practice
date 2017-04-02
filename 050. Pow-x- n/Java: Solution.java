public class Solution {
    // x^n = x^(n/2) * x^(n/2) * x^(n%2)，所以每次我们x*x，然后n/2，进行递归
    // 时间复杂度O(logn)，空间复杂度O(logn)
    public double myPow(double x, int n) 
    {
        // 指数为0，幂为1
        if(n == 0) 
            return 1;
        // 指数为最小整型数，如果我们只是简单地取-n会溢出，需要特别处理
        if(n == Integer.MIN_VALUE)
        {
            // 预处理x和n，先进行一次平方
            x = x * x;
            n = n / 2;
        }
        // 指数为负数
        if(n < 0) 
        {
            n = -n;
            x = 1 / x;
        }
        // 对n为奇数和偶数的情况下做不同的处理，奇数时我们只需对递归返回的数再乘以一个x即可
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}

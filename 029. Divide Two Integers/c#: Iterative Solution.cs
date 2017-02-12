public class Solution {
    // 迭代法，套用递归方法只是把递归用作外层循环，内层依然沿用递归
    public int Divide(int dividend, int divisor) 
    {
        // 控制溢出
        if(divisor == 0 || (dividend == Int32.MinValue && divisor == -1))
            return Int32.MaxValue;
        // 获取相处以后的符号位
        int sign = (dividend ^ divisor) >> 31;
        long sum =divisor;
        int multiple = 1, quotient = 0;
        long tempDividend = Math.Abs((long)dividend), tempDivisor = Math.Abs((long)divisor);
        // 迭代
        while(tempDivisor <= tempDividend)
        {
            sum = tempDivisor;
            multiple = 1;
            while((sum << 1) <= tempDividend)
            {
                sum <<= 1;
                multiple <<= 1;
            }
            tempDividend -= sum;
            quotient += multiple;
        }
        return sign == 0 ? quotient : -quotient;
    }
}

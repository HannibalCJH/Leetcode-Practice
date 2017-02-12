public class Solution {
    public int Divide(int dividend, int divisor) 
    {
        // 控制溢出
        if(divisor == 0 || (dividend == Int32.MinValue && divisor == -1))
            return Int32.MaxValue;
        // 获取相处以后的符号位
        int sign = (dividend ^ divisor) >> 31;
        int quotient = DivideHelper(Math.Abs((long)dividend), Math.Abs((long)divisor));
        return sign == 0 ? quotient : -quotient;
    }
    
    public int DivideHelper(long dividend, long divisor)
    {
        if(dividend < divisor)
            return 0;
        long sum = divisor;
        int multiple = 1;
        while((sum << 1) <= dividend)
        {
            sum <<= 1;
            multiple <<= 1;
        }
        
        multiple += DivideHelper(dividend - sum, divisor);
        return multiple;
    }
}

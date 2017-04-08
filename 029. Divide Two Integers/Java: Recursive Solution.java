public class Solution {
    // 时间复杂度O((logn)^2)，趋近O(n)，这里类似二分法，递归层数和每层递归中的循环各为O(logn)
    // 空间复杂度O(logn)，递归层数
    public int divide(int dividend, int divisor) 
    {
        // 溢出情况
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) 
            return Integer.MAX_VALUE;
        // 取得相除以后的符号位，0为正，1为负
        // >>>表示无符号位右移，缺位补0
        int sign = (dividend ^ divisor) >>> 31;
        // 注意把被除数和除数都转成长整型
        int quotient = divideHelper(Math.abs((long)dividend), Math.abs((long)divisor));
        return sign == 0 ? quotient : -quotient;
    }
    
    private int divideHelper(long dividend, long divisor) 
    {
        // 被除数小于除数，整数部分为0
        if(dividend < divisor) 
            return 0;
        // 找最大的倍数，让除数翻倍后仍然小于被除数，即divisor * multiple <= dividend
        // 考虑到performance，我们这里每次翻一倍1, 2, 4, 8, 16...2^n
	// 可以理解为二分法，每次其实该层递归只计算了dividend/2，
	// 后面因为sum翻倍以后超过了dividend就算到了下一次递归中
	// 初始化sum为divisor
        long sum = divisor;
        // 初始化倍数为1
        int multiple = 1;
        // 如果sum翻一倍小于被除数那救让sum和multiple翻一倍
        while((sum << 1) <= dividend) 
        {
            // sum和multiple翻倍
            sum <<= 1;
            multiple <<= 1;
        }
        // 因为我们是每次翻倍，跨度比较大，递归计算余下的部分
        multiple += divideHelper(dividend - sum, divisor);
        return multiple;
    }
}

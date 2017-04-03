public class Solution {
    // 二分搜索，x的根小于x/2 + 1
    // 时间复杂度O(logx)，空间复杂度O(1)
    public int mySqrt(int x) 
    {
	// 这里注意要用long
	long left = 0;  
	long right = x / 2 + 1;  
	while(left <= right) 
	{  
	    long mid = (left + right) / 2;
	    // 算中间数的平方
	    long square = mid * mid;
	    // 等于x则找到平方根
	    if(square == x)  
	        return (int)mid;
	    else if(square < x)  
	        left = mid + 1;  
	    else  
	        right = mid - 1;  
	}  
	return (int)right;  
    }
}

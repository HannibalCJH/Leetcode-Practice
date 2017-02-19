public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public int maxSubArray(int[] A) 
    {
	// 记录全局最大值
        int maxSum = Integer.MIN_VALUE;  
        // 记录当前最大值
        int temp = 0;  
        for(int i = 0; i < A.length; i++)
        {  
            // 如果temp+A[i]比A[i]大，那A[i]属于temp形成的子数组
            // 不然重新开始一个以A[i]开头的子数组
            temp = Math.max(temp + A[i], A[i]);  
            // 比较全局和当前最大值，如果当前的大则更新为全局最大值
            maxSum = Math.max(temp, maxSum);  
        }  
        return maxSum;  
    }
}

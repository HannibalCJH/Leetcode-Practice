public class Solution {
    // 暴力做法
    // 时间复杂度O(n^n)，空间复杂度O(1)
    public int maxRotateFunction(int[] A) 
    {
        if(A == null || A.length == 0)
            return 0;
        
        int max = Integer.MIN_VALUE;
        int n = A.length;
        for(int i = n; i >= 0; i--)
        {
            // 开始的位置
            int start = i % A.length;
            max = Math.max(max, calculate(A, start));
        }
        return max;
    }
    
    // 计算这一轮的和
    private int calculate(int[] A, int start)
    {
        int sum = 0;
        int count = 0, index = start;
        while(count < A.length)
        {
            sum += count++ * A[index++];
            // 走到底了从0接上
            if(index == A.length)
            {
                index = 0;
            }
        }
        return sum;
    }
}

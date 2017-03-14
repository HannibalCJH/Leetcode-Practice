public class Solution {
    public int MaxRotateFunction(int[] A) 
    {
        if(A == null || A.Length == 0)
            return 0;
        
        int max = Int32.MinValue;
        int n = A.Length;
        for(int i = n; i >= 0; i--)
        {
            // 开始的位置
            int start = i % n;
            max = Math.Max(max, Calculate(A, start));
        }
        return max;
    }
    
    // 计算这一轮的和
    private int Calculate(int[] A, int start)
    {
        int sum = 0;
        int count = 0, index = start;
        while(count < A.Length)
        {
            sum += count++ * A[index++];
            // 走到底了从0接上
            if(index == A.Length)
            {
                index = 0;
            }
        }
        return sum;
    }
}

public class Solution {
    // 解释参考https://discuss.leetcode.com/topic/58616/java-solution-o-n-with-non-mathametical-explaination
    // 时间复杂度O(n)，空间复杂度O(1)
    public int maxRotateFunction(int[] A) 
    {
        int iteration = 0;
        // 数组所有元素的和
        int sum = 0;
        for(int i = 0; i < A.length; i++)
        {
            iteration += A[i] * i;
            sum += A[i];
        }
        // 初始化为第一趟的和也就是F(0)
        int max = iteration;
        for(int j = A.length - 1; j >= 1; j--)
        {
            iteration = iteration + sum - A.length * A[j];
            max = Math.max(max, iteration);
        }
        return max;  
    }
}

public class Solution {
    public int MaxRotateFunction(int[] A) 
    {
        int iteration = 0, sum = 0;
        int n = A.Length;
        for(int i = 0; i < n; i++)
        {
            iteration += i * A[i];
            sum += A[i];
        }
        
        int max = iteration;
        for(int i = n - 1; i >= 1; i--)
        {
            iteration = iteration + sum - n * A[i];
            max = Math.Max(max, iteration);
        }
        return max;
    }
}

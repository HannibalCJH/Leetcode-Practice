public class Solution {
    public int MaximalRectangle(char[,] matrix) 
    {
        if(matrix == null || matrix.GetLength(0) == 0 || matrix.GetLength(1) == 0)
            return 0;
        
        int m = matrix.GetLength(0), n = matrix.GetLength(1);
        int[] left = new int[n], right = new int[n], height = new int[n];
        for(int i = 0; i < n; i++)
        {
            right[i] = n;
        }
        int result = 0;
        for(int i = 0; i < m; i++)
        {
            int cur_left = 0, cur_right = n;
            for(int j = 0; j < n; j++)
            {
                if(matrix[i, j] == '1')
                {
                    height[j]++;
                    left[j] = Math.Max(left[j], cur_left);
                }
                else
                {
                    height[j] = 0;
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            for(int j = n - 1; j >= 0; j--)
            {
                if(matrix[i, j] == '1')
                {
                    right[j] = Math.Min(right[j], cur_right);
                }
                else
                {
                    right[j] = n;
                    cur_right = j;
                }
            }
            for(int j = 0; j < n; j++)
            {
                result = Math.Max(result, (right[j] - left[j]) * height[j]);
            }
        }
        return result;
    }
}

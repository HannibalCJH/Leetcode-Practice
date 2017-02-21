public class Solution {
    public void SetZeroes(int[,] matrix) 
    {
        if(matrix == null || matrix.GetLength(0) == 0 || matrix.GetLength(1) == 0)
            return;
        
        int m = matrix.GetLength(0), n = matrix.GetLength(1);
        bool[] rows = new bool[m];
        bool[] cols = new bool[n];
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i, j] == 0)
                {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(rows[i] || cols[j])
                    matrix[i, j] = 0;
            }
        }
    }
}

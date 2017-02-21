public class Solution {
    public void SetZeroes(int[,] matrix) 
    {
        if(matrix == null || matrix.GetLength(0) == 0 || matrix.GetLength(1) == 0)
            return;
        
        int m = matrix.GetLength(0), n = matrix.GetLength(1);
        bool firstRow = false, firstCol = false;
        // 第一行
        for(int i = 0; i < n; i++)
        {
            if(matrix[0, i] == 0)
            {
                firstRow = true;
                break;
            }
        }
        
        // 第一列
        for(int i = 0; i < m; i++)
        {
            if(matrix[i, 0] == 0)
            {
                firstCol = true;
                break;
            }
        }
        
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                if(matrix[i, j] == 0)
                {
                    matrix[0, j] = 0;
                    matrix[i, 0] = 0;
                }
            }
        }
        
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                if(matrix[i, 0] == 0 || matrix[0, j] == 0)
                    matrix[i, j] = 0;
                    
        if(firstRow)
        {
            for(int i = 0; i < n; i++)
                matrix[0, i] = 0;
        }
        if(firstCol)
        {
            for(int i = 0; i < m; i++)
                matrix[i, 0] = 0;
        }
        
    }
}

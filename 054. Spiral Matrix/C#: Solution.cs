public class Solution {
    public IList<int> SpiralOrder(int[,] matrix) 
    {
        if(matrix == null || matrix.GetLength(0) == 0 || matrix.GetLength(1) == 0)
            return new List<int>();
        
        IList<int> result = new List<int>();
        int m = matrix.GetLength(0), n = matrix.GetLength(1);
        int layer = (Math.Min(m, n) + 1) / 2;
        
        for(int i = 0; i < layer; i++)
        {
            int lastRow = m - 1 - i, lastCol = n - 1 - i;
            // 只有一行
            if(i == lastRow)
            {
                for(int j = i; j <= lastCol; j++)
                    result.Add(matrix[lastRow, j]);
            }
            // 只有一列
            else if(i == lastCol)
            {
                for(int j = i; j <= lastRow; j++)
                    result.Add(matrix[j, lastCol]);
            }
            else
            {
                // 第一行
                for(int j = i; j <= lastCol - 1; j++)
                    result.Add(matrix[i, j]);
                // 最后一列
                for(int j = i; j <= lastRow - 1; j++)
                    result.Add(matrix[j, lastCol]);
                // 最后一行
                for(int j = lastCol; j >= i + 1; j--)
                    result.Add(matrix[lastRow, j]);
                // 第一列
                for(int j = lastRow; j >= i + 1; j--)
                    result.Add(matrix[j, i]);
            }
        }
        return result;
    }
}

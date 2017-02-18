public class Solution {
    // 时间复杂度O(mn)，空间复杂度O(1)
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new ArrayList<Integer>();
            
        List<Integer> result = new ArrayList<Integer>();
        int m = matrix.length, n = matrix[0].length;
        // 计算层数
        int layer = (Math.min(m, n) + 1) / 2;
        
        for(int i = 0; i < layer; i++)
        {
            // 最后一行和最后一列
            int lastRow = m - 1 - i, lastCol = n - 1 - i;
            // 只有一行
            if(i == lastRow)
            {
                for(int j = i; j <= lastCol; j++)
                    result.add(matrix[lastRow][j]);
            }
            // 只有一列
            else if(i == lastCol)
            {
                for(int j = i; j <= lastRow; j++)
                    result.add(matrix[j][lastCol]);
            }
            else
            {
                // 第一行
                for(int j = i; j <= lastCol - 1; j++)
                    result.add(matrix[i][j]);
                // 最后一列
                for(int j = i; j <= lastRow - 1; j++)
                    result.add(matrix[j][lastCol]);
                // 最后一行
                for(int j = lastCol; j >= i + 1; j--)
                    result.add(matrix[lastRow][j]);
                // 第一列
                for(int j = lastRow; j >= i + 1; j--)
                    result.add(matrix[j][i]); 
            }
        }
        return result;
    }
}

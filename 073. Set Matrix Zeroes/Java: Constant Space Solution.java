public class Solution {
    // 时间复杂度O(mn)，空间复杂度O(1)
    public void setZeroes(int[][] matrix) 
    {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow = false, firstCol = false;
        
        // 先扫一遍第一行和第一列，确定其中是否有0
        for(int i = 0; i < n; i++)
        {
            if(matrix[0][i] == 0)
            {
                firstRow = true;
                break;
            }
        }
        for(int i = 0; i < m; i++)
        {
            if(matrix[i][0] == 0)
            {
                firstCol = true;
                break;
            }
        }
        
        // 扫一遍矩阵，把行和列是否变0的标识放在第一行和第一列
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 再扫一遍把除了第一行和第一列的元素根据标识变为0
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
        // 根据标识把第一行和第一列变为0
        if(firstRow)
        {
            for(int i = 0; i < n; i++)
                matrix[0][i] = 0;
        }
        if(firstCol)
        {
            for(int i = 0; i < m; i++)
                matrix[i][0] = 0;
        }
    }
}

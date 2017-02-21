public class Solution {
    // 时间复杂度O(mn)，空间复杂度O(m+n)
    public void setZeroes(int[][] matrix) 
    {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        
        int m = matrix.length, n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        
        // 第一遍，标记要变为0的行和列
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(matrix[i][j] == 0)
                {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        
        // 第二遍，根据标记把相应的行和列变为0
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                // 行或列被标记为要变为0
                if(rows[i] || cols[j])
                    matrix[i][j] = 0;
            }
        }
    }
}

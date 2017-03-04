public class Solution {
    // 时间复杂度O(m+n)，最坏情况是从右上角一直找到左下角即m+n
    // 空间复杂度O(1)
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        // 从右上角开始搜索，不断缩小目标所在的矩阵的大小
        while(row < m && col >= 0)
        {
            // 找到目标
            if(matrix[row][col] == target)
                return true;
            // 小于目标，移到下一行，因为下一行的数更大
            else if(matrix[row][col] < target)
                row++;
            else
                // 大于目标，移到前一列，因为前一列的数更小
                col--;
        }
        return false;
    }
}

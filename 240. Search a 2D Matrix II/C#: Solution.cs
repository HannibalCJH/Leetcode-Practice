public class Solution {
    public bool SearchMatrix(int[,] matrix, int target) 
    {
        if(matrix.GetLength(0) == 0 || matrix.GetLength(1) == 0)
            return false;
        
        int m = matrix.GetLength(0), n = matrix.GetLength(1);
        int row = 0, col = n - 1;
        while(row < m && col >= 0)
        {
            if(matrix[row, col] == target)
                return true;
            else if(matrix[row, col] < target)
                row++;
            else
                col--;
        }
        return false;
    }
}

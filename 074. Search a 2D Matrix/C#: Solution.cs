public class Solution {
    public bool SearchMatrix(int[,] matrix, int target) 
    {
        if(matrix.GetLength(0) == 0 || matrix.GetLength(1) == 0)
            return false;
        
        int m = matrix.GetLength(0), n = matrix.GetLength(1);
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while(top <= bottom)
        {
            int midRow = top + (bottom - top) / 2;
            if(matrix[midRow, 0] > target)
                bottom = midRow - 1;
            else if(matrix[midRow, n - 1] < target)
                top = midRow + 1;
            else
            {
                while(left <= right)
                {
                    int midCol = left + (right - left) / 2;
                    if(matrix[midRow, midCol] == target)
                        return true;
                    else if(matrix[midRow, midCol] < target)
                        left = midCol + 1;
                    else
                        right = midCol - 1;
                }
                return false;
            }
        }
        return false;
    }
}

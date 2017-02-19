public class Solution {
    public void Rotate(int[,] matrix) 
    {
        if(matrix == null || matrix.GetLength(0) == 0 || matrix.GetLength(1) == 0)
            return;
            
        int n = matrix.GetLength(0), layer = n / 2;
        for(int i = 0; i < layer; i++)
        {
            int temp1, temp2;
            for(int j = i; j < n - 1 - i; j++)
            {
                temp1 = matrix[j, n - 1 - i];
                matrix[j, n - 1 - i] = matrix[i, j];
                temp2 = matrix[n - 1 - i, n - 1 - j];
                matrix[n - 1 - i, n - 1 - j] = temp1;
                temp1 = matrix[n - 1 - j, i];
                matrix[n - 1 - j, i] = temp2;
                matrix[i, j] = temp1;
            }
        }
    }
}

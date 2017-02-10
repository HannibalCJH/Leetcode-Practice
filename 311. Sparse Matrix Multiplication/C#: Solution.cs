public class Solution {
    public int[,] Multiply(int[,] A, int[,] B) 
    {
        int m = A.GetLength(0), n = A.GetLength(1), h = B.GetLength(1);
        List<int>[] ANums = new List<int>[m];
        int[,] C = new int[m,h];
        // 存稀疏矩阵A的非零元素
        for(int i = 0; i < m; i++)
        {
            ANums[i] = new List<int>();
            for(int j = 0; j < n; j++)
            {
                if(A[i,j] != 0)
                {
                    ANums[i].Add(j);
                    ANums[i].Add(A[i,j]);
                }
            }
        }
        
        for(int i = 0; i < m; i++)
        {
            List<int> ARow = ANums[i];
            for(int pos = 0; pos < ARow.Count - 1; pos += 2)
            {
                int col = ARow[pos];
                int valA = ARow[pos+1];
                for(int j = 0; j < h; j++)
                {
                    C[i,j] += valA * B[col,j];
                }
            }
        }
        return C;
    }
}

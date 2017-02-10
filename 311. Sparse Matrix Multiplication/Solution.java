public class Solution {
    // 时间复杂度O(mnh)，空间复杂度O(mh)
    public int[][] multiply(int[][] A, int[][] B) 
    {
        // 两个矩阵相乘，矩阵A的列数必须等于矩阵B的行数
        // A为m x n，B为n x h，最后相乘的结果C为m x h
        int m = A.length, n = A[0].length, h = B[0].length;
        int[][] C = new int[m][h];
        // 存A矩阵中的非零元素
        List[] ANums = new List[m];
        // 把稀疏矩阵A转换成链表
        for(int i = 0; i < m; i++)
        {
            // 每行都是一个ArrayList
            ANums[i] = new ArrayList<Integer>();
            for(int j = 0; j < n; j++)
            {
                // 非零元素
                if(A[i][j] != 0)
                {
                    // 一次存两个，先存列下标，再存元素
                    ANums[i].add(j);
                    ANums[i].add(A[i][j]);
                }
            }
        }
        // 矩阵相乘
        for(int i = 0; i < m; i++)
        {
            // 取出A矩阵第i行的非零元素
            List<Integer> ACols = ANums[i];
            // 存的时候是一组存两个，先列下标后元素，所以每次跳两个
            for(int pos = 0; pos < ACols.size() - 1; pos += 2)
            {
                int col = ACols.get(pos);
                int valA = ACols.get(pos + 1);
                for(int j = 0; j < h; j++)
                {
                    C[i][j] += valA * B[col][j];
                }
            }
        }
        return C;
    }
}

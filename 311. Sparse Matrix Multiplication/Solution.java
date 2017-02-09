public class Solution {
    // 稀疏矩阵表示法：http://www.cs.cmu.edu/~scandal/cacm/node9.html
    // 时间复杂度O(mnh)，空间复杂度O(mh)
    public int[][] multiply(int[][] A, int[][] B) 
    {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] result = new int[m][nB];
        
        // 用一个List数组来记录矩阵A的非零元素
        // 每行为一个List，List中先存一个index再存这个index对应的元素
        List[] indexA = new List[m];
        for(int i = 0; i < m; i++) 
        {
            List<Integer> numsA = new ArrayList<Integer>();
            for(int j = 0; j < n; j++) 
            {
                // 非零元素
                if(A[i][j] != 0)
                {
                    numsA.add(j); 
                    numsA.add(A[i][j]);
                }
            }
            indexA[i] = numsA;
        }
        
        // 矩阵相乘
        for(int i = 0; i < m; i++) 
        {
            List<Integer> numsA = indexA[i];
            // 每次跳过两个，第一个是index第二个是对应的元素，两个为一组
            for(int p = 0; p < numsA.size() - 1; p += 2) 
            {
                int colA = numsA.get(p);
                int valA = numsA.get(p + 1);
                for(int j = 0; j < nB; j++) 
                {
                    int valB = B[colA][j];
                    result[i][j] += valA * valB;
                }
            }
        }
    
        return result;   
    }
}

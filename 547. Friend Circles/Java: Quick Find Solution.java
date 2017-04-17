class UnionFind
{
    int[] circles;
    int size;
    
    public UnionFind(int n)
    {
        circles = new int[n];
        size = n;
        for(int i = 0; i < n; i++)
        {
            circles[i] = i;
        }
    }
    
    public int find(int x)
    {
        return circles[x];
    }
    
    public void union(int x, int y)
    {
        int circle_x = find(x), circle_y = find(y);
        // 只有当两个人不属于同一个朋友圈的时候才需要合并，已经在前面通过间接关系合并成同一个圈子的就不用再合并
        if(circle_x == circle_y)
            return;
        
        for(int i = 0; i < circles.length; i++)
        {
            if(circles[i] == circle_y)
                circles[i] = circle_x;
        }
        size--;
    }
    
    public int count()
    {
        return size;
    }
}



// 时间复杂度O(n+n^3)，空间复杂度O(n)
public class Solution {
    public int findCircleNum(int[][] M) 
    {
        if(M == null || M.length == 0 || M[0].length == 0)
            return 0;
        
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                // 两个人是直接朋友就进行合并
                if(M[i][j] == 1)
                    uf.union(i, j);
            }
        }
        return uf.count();
    }
}

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
    
    public int Find(int x)
    {
        return circles[x];
    }
    
    public void Union(int x, int y)
    {
        int circle_x = Find(x), circle_y = Find(y);
        if(circle_x == circle_y)
            return;
        
        for(int i = 0; i < circles.Length; i++)
        {
            if(circles[i] == circle_y)
                circles[i] = circle_x;
        }
        size--;
    }
    
    public int Count()
    {
        return size;
    }
}


public class Solution {
    public int FindCircleNum(int[,] M) 
    {
        if(M == null || M.GetLength(0) == 0 || M.GetLength(1) == 0)
            return 0;
        
        int n = M.GetLength(0);
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
            {
                if(M[i, j] == 1)
                    uf.Union(i, j);
            }
        }
        return uf.Count();
    }
}

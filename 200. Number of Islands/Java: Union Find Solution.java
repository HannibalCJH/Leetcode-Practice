public class Solution {
    public int numIslands(char[][] grid) 
    {
        if(grid == null || grid.length == 0 || grid[0].length == 0) 
            return 0;
        int row = grid.length;
        int col = grid[0].length;
    
        UnionFind island = new UnionFind(row, col, grid);
        
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
            {
                if(grid[i][j] == '1')
                {
                    int p = i * col + j;
                    //right
                    if(j < col - 1 && grid[i][j + 1] == '1')
                    {
                        int q = i * col + j + 1;
                        if(!island.find(p, q))
                            island.union(p, q);
                    }
                    //down
                    if(i < row - 1 && grid[i + 1][j] == '1')
                    {
                        int q = (i + 1) * col + j;
                        if(!island.find(p, q))
                            island.union(p, q);
                    }
                }
            }
        return island.size();
    }
}

class UnionFind
{
    private int[] id, size;
    private int count;
    
    public UnionFind(int row, int col, char[][] grid)
    {
        id = new int[row * col];
        size = new int[row * col];
        
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                if(grid[i][j] == '1') 
                    this.count++;
        
        for(int i = 0; i < row * col; i++)
        {
            id[i] = i;
            size[i] = 1;
        }
    }
    
    public int size() { return this.count; }
    
    private int root(int i)
    {
        while(i != id[i])
        {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    
    public boolean find(int p, int q)
    {
        return root(p) == root(q);
    }
    
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        
        if(size[i] < size[j])
        {
            id[i] = j;
            size[j] += size[i];
        }
        else
        {
            id[j] = i;
            size[i] -= size[j];
        }
        count --;
    }
}

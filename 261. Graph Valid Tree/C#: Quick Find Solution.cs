class UnionFind
{
    int[] ids;
    int count;
    
    // 构造函数
    public UnionFind(int size)
    {
        this.ids = new int[size];
        // 初始化所有节点各自为一个集合
        for(int i = 0; i < size; i++)
            ids[i] = i;
        this.count = size;
    }
    
    public bool Union(int x, int y)
    {
        int id_x = Find(x), id_y = Find(y);
        // 不在同一个集合中
        if(id_x != id_y)
        {
            // 扫一遍数组把所有和x在一个集合中的节点都合并到y所属的集合中
            for(int i = 0; i < ids.Length; i++)
            {
                if(ids[i] == id_x)
                    ids[i] = id_y;
            }
            // x和y各自所属的集合合并后减少了一个集合
            this.count--;
            return true;
        }
        else
            // 两个节点已经在一个集合中了，这样就形成了一个环
            return false;
    }
    
    public int Find(int x)
    {
        return this.ids[x];
    }
    
    public int Count()
    {
        return this.count;
    }
}


public class Solution {
    public bool ValidTree(int n, int[,] edges) 
    {
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < edges.GetLength(0); i++)
        {
            // 已经在一个集合中，形成了环
            if(!uf.Union(edges[i,0], edges[i,1]))
                return false;
        }
        // 只有一个集合才是树
        return uf.Count() == 1;
    }
}

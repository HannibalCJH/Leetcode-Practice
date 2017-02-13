class UnionFind
{
    Dictionary<int, int> father = new Dictionary<int, int>();
    
    // 构造函数
    public UnionFind(int size)
    {
        // 初始化每个节点都为自己的父节点
        for(int i = 0; i < size; i++)
        {
            father.Add(i, i);
        }
    }
    
    public int CompressFind(int x)
    {
        int parent = father[x];
        // 寻找当前节点所在树的根节点即父节点是其自身
        while(parent != father[parent])
        {
            parent = father[parent];
        }
        // 再扫一遍，把刚才路径上的节点的父节点也都设置为parent
        int temp;
        int fa = father[x];
        while(fa != father[fa])
        {
            temp = father[fa];
            father[fa] = parent;
            fa = temp;
        }
        // 返回找到的根节点
        return parent;
    }
    
    public void Union(int id_x, int id_y)
    {
        if(id_x != id_y)
        {
            father[id_x] = id_y;
        }
    }
}

public class Solution {
    public bool ValidTree(int n, int[,] edges) 
    {
        // 作为一棵树，节点的个数肯定比边数目大1
        if(n - 1 != edges.GetLength(0))
            return false;
        
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < edges.GetLength(0); i++)
        {
            int parent_x = uf.CompressFind(edges[i,0]);
            int parent_y = uf.CompressFind(edges[i,1]);
            if(parent_x == parent_y)
                return false;
            uf.Union(parent_x, parent_y);
        }
        return true;
    }
}

class UnionFind
{
    // 节点的父节点，键值对[node, father]
    HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
    // 构造函数
    public UnionFind(int n)
    {
        //初始化并查集，每个节点都是自己的父节点
        for(int i = 0 ; i < n; i++) 
        {
            father.put(i, i); 
        }
    }
    
    public int compressed_find(int x)
    {
        // 获得父节点
        int parent =  father.get(x);
        // 一直找父节点，直到找到根节点，即该节点的父节点是其自身
        while(parent != father.get(parent)) 
        {
            parent = father.get(parent);
        }
        int temp;
        int fa = father.get(x);
        // 重新再扫一遍刚才的路径，把路径上的节点的父节点都设成parent
        while(fa != father.get(fa)) 
        {
            temp = father.get(fa);
            father.put(fa, parent) ;
            fa = temp;
        }
        return parent;
    }
    
    public void union(int id_x, int id_y)
    {
        // 如果属于不同集合，把x加到y的集合中
        // x的父节点设成y
        if(id_x != id_y)
            father.put(id_x, id_y);
    }
}

public class Solution {
    // 时间复杂度O(h^m)，h为树的高度，m为边的数目
    // 空间复杂度O(n)
    public boolean validTree(int n, int[][] edges) 
    {
        // 作为一棵树，节点的个数肯定要比边的数大1
        // 这里排除了可能有两个不连通的部分
        if(n - 1 != edges.length) 
        {
            return false;
        }
        
        UnionFind uf = new UnionFind(n);
        
        for(int i = 0; i < edges.length; i++) 
        {
            // 获取两个节点各自的树的父节点
            int parent_src = uf.compressed_find(edges[i][0]);
            int parent_dst = uf.compressed_find(edges[i][1]);
            // 父节点相同即在同一个集合中，重复加入形成了环
            if(parent_src == parent_dst)
                return false;
            // 把两个节点合并到一棵树下
            uf.union(parent_src, parent_dst);
        }
        return true;    
    }
}

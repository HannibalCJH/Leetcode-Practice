class UnionFind 
{
    // 节点所属集合编号
    int[] ids;
    // 有多少集合
    int count;
    
    // 构造函数
    public UnionFind(int size)
    {
        this.ids = new int[size];
        //初始化并查集，每个节点各自为一个集合
        for(int i = 0; i < this.ids.length; i++)
            this.ids[i] = i;
        this.count = size;
    }
    
    // 合并两个集合
    // 时间复杂度O(n)，每次扫一遍所有节点的所属集合
    public boolean union(int m, int n)
    {
    	// 分别获取两个节点当前所在集合编号
        int src = find(m);
        int dst = find(n);
        //如果两个节点不在同一集合中，将两个集合合并为一个
        if(src != dst)
        {
        	// 把所有和src同集合的节点并入dst所在的集合
            for(int i = 0; i < ids.length; i++)
                if(ids[i] == src)
                    ids[i] = dst;
            // 合并完集合后，集合数减1
            count--;
            return true;
        } 
        // 两个节点已经在同一个集合，这条边会产生环
        else
            return false;
    }
    
    // 查找节点所在集合编号
    public int find(int m)
    {
        return ids[m];
    } 
    
    public int count()
    {
        return count;
    }
}


public class Solution {
    // 时间复杂度O(mn)，m为边的个数，n为节点的个数，每条边都要执行union操作
    // 空间复杂度O(n)
    public boolean validTree(int n, int[][] edges) 
    {
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < edges.length; i++)
            // 如果两个节点已经在同一集合中，说明新的边将产生环路
            if(!uf.union(edges[i][0], edges[i][1]))
                return false;
        // 如果是树，则最后所有节点都合并到一个集合且没有环
        return uf.count() == 1;
    }
}

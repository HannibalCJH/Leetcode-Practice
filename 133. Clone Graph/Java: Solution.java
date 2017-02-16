/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    // 时间复杂度O(n)，访问所有的节点且仅访问了一次
    // 空间复杂度O(n)
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) 
	{
        if(node == null) 
        	return node;
        // 用队列来实现广度优先搜索无向图
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        // 用哈希表储存原图与克隆图中节点映射关系
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node, root);
        queue.offer(node);
        // 广度优先搜索
        while(!queue.isEmpty())
        {
            UndirectedGraphNode curr = queue.poll();
            // 将原图curr节点的邻居节点都加入克隆图忠curr对应节点的邻居里
            for(UndirectedGraphNode oldNeighbor : curr.neighbors)
            {
                // 判断是否已经生成过该邻居节点的克隆节点
                if(!map.containsKey(oldNeighbor))
                {
                    // 如果是第一次生成该克隆节点，将其加入队列中
                    map.put(oldNeighbor, new UndirectedGraphNode(oldNeighbor.label));
                    // 只需要在第一次生成该映射关系时加入队列，如果map中已经有这个节点则说明已经加入过队列无需重复加入
                    queue.offer(oldNeighbor);
                }
                // 将原图中curr的这个邻居加入克隆图中curr对应节点的neighbors中
                map.get(curr).neighbors.add(map.get(oldNeighbor));
            }
        }
        return root;
    }
}

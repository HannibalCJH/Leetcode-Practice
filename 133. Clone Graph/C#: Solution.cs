/**
 * Definition for undirected graph.
 * public class UndirectedGraphNode {
 *     public int label;
 *     public IList<UndirectedGraphNode> neighbors;
 *     public UndirectedGraphNode(int x) { label = x; neighbors = new List<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode CloneGraph(UndirectedGraphNode node) 
    {
        if(node == null)
            return node;
        Dictionary<UndirectedGraphNode, UndirectedGraphNode> map = new Dictionary<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.Add(node, root);
        Queue<UndirectedGraphNode> queue = new Queue<UndirectedGraphNode>();
        queue.Enqueue(node);
        while(queue.Count != 0)
        {
            UndirectedGraphNode cur = queue.Dequeue();
            foreach(UndirectedGraphNode oldNeighbor in cur.neighbors)
            {
                if(!map.ContainsKey(oldNeighbor))
                {
                    map.Add(oldNeighbor, new UndirectedGraphNode(oldNeighbor.label));
                    queue.Enqueue(oldNeighbor);
                }
                map[cur].neighbors.Add(map[oldNeighbor]);
            }
        }
        return root;
    }
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    // 时间复杂度O(n)，n为整数的个数
    // 空间复杂度O(h)，h为平均每层的NestedInteger的个数
    public int depthSum(List<NestedInteger> nestedList) 
    {
        if(nestedList == null || nestedList.size() == 0)
            return 0;
            
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        // 可以把nestedList看成是有多个连通部分的图，根节点不止一个
        for(NestedInteger nint : nestedList)
            queue.offer(nint);
        
        int sum = 0, depth = 0;
        // BFS
        while(!queue.isEmpty())
        {
            int size = queue.size();
            depth++;
            for(int i = 0; i < size; i++)
            {
                NestedInteger nint = queue.poll();
                if(nint.isInteger())
                    sum += depth * nint.getInteger();
                else
                {
                    for(NestedInteger next : nint.getList())
                        queue.offer(next);
                }
            }
        }
        return sum;
    }
}

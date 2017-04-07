/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    // 时间复杂度O(n)，n为整数的个数
    // 空间复杂度O(h)，h为平均每层的NestedInteger的个数
    public int depthSumInverse(List<NestedInteger> nestedList) 
    {
        if(nestedList == null || nestedList.size() == 0)
            return 0;
        
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        for(NestedInteger nint : nestedList)
            queue.offer(nint);
        
        int total = 0, preSum = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                NestedInteger nint = queue.poll();
                // 统计从第一层到这一层的整数和
                if(nint.isInteger())
                    preSum += nint.getInteger();
                else
                {
                    for(NestedInteger next : nint.getList())
                        queue.offer(next);
                }
            }
            // 加到总数上，注意点如下
            // 1. 第一层的preSum是第一层的整数和，加到total里后那么total里的第一层和的倍数为1
            // 2. 第二层的preSum是第一层和第二层的整数和，加到total里后那么total里第一层的倍数为2，第二层的倍数为1
            // 3. 第三层的preSum是第一层到第三层的整数和，加到total里后那么total里的第一层的倍数就为3，第二层的倍数为2，第三层的倍数为1
            // 4. 依次往下类推
            total += preSum;
        }
        return total;
    }
}

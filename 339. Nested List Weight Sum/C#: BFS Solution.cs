/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool IsInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     int GetInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     IList<NestedInteger> GetList();
 * }
 */
public class Solution {
    public int DepthSum(IList<NestedInteger> nestedList) 
    {
        if(nestedList == null || nestedList.Count == 0)
            return 0;
        
        Queue<NestedInteger> queue = new Queue<NestedInteger>();
        foreach(NestedInteger nint in nestedList)
        {
            queue.Enqueue(nint);
        }
            
        int sum = 0, depth = 0;
        while(queue.Count > 0)
        {
            int size = queue.Count;
            depth++;
            for(int i = 0; i < size; i++)
            {
                NestedInteger nint = queue.Dequeue();
                if(nint.IsInteger())
                    sum += depth * nint.GetInteger();
                else
                {
                    foreach(NestedInteger next in nint.GetList())
                    {
                        queue.Enqueue(next);
                    }
                }
            }
        }
        return sum;
    }
}

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
        return DFS(nestedList, 1);    
    }
    
    private int DFS(IList<NestedInteger> nestedList, int depth)
    {
        if(nestedList == null || nestedList.Count == 0)
            return 0;
        
        int sum = 0;
        foreach(NestedInteger nint in nestedList)
        {
            if(nint.IsInteger())
                sum += depth * nint.GetInteger();
            else
                sum += DFS(nint.GetList(), depth + 1);
        }
        return sum;
    }
}

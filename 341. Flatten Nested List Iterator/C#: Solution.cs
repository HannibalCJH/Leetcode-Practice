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
public class NestedIterator {
    Stack<NestedInteger> stack;

    public NestedIterator(IList<NestedInteger> nestedList) 
    {
        stack = new Stack<NestedInteger>();
        for(int i = nestedList.Count - 1; i >= 0; i--)
        {
            stack.Push(nestedList[i]);
        }
    }

    public bool HasNext() 
    {
        while(stack.Count > 0)
        {
            if(stack.Peek().IsInteger())
                return true;
                
            IList<NestedInteger> cur = stack.Pop().GetList();
            for(int i = cur.Count - 1; i >= 0; i--)
            {
                stack.Push(cur[i]);
            }
        }
        return false;
    }

    public int Next() 
    {
        return stack.Pop().GetInteger(); 
    }
}

/**
 * Your NestedIterator will be called like this:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.HasNext()) v[f()] = i.Next();
 */

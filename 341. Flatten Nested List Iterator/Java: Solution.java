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
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;

    // 时间复杂度O(n)，空间复杂度O(n)，n为列表长度
    public NestedIterator(List<NestedInteger> nestedList) 
    {
        stack = new Stack<NestedInteger>();
        // 把列表逆序压入栈
        for(int i = nestedList.size() - 1; i >= 0; i--)
        {
            stack.push(nestedList.get(i));
        }
    }

    // 时间复杂度O(1)，空间复杂度O(k)，k为所有元素个数
    @Override
    public Integer next() 
    {
        return stack.pop().getInteger();    
    }

    @Override
    // 时间复杂度O(k)，空间复杂度O(k)，k为所有元素个数
    public boolean hasNext() 
    {
        // 一直循环，如果遇到有整数那就返回真，不然就返回假，比如有的情况是[[]]也应该返回假
        while(!stack.isEmpty())
        {
            // 如果栈顶是个整数那就有下一个
            if(stack.peek().isInteger())
                return true;
            // 如果是列表就遍历列表把所有元素压入栈
            List<NestedInteger> cur = stack.pop().getList();
            for(int i = cur.size() - 1; i >= 0; i--)
                stack.push(cur.get(i));
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

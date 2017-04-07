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
    // 空间复杂度O(mh)，m为平均每一层list而不是integer的数，我们每层都要生成一个nextLevel，h为深度
    public int depthSumInverse(List<NestedInteger> nestedList) 
    {
        return dfs(nestedList, 0);
    }
    // 和Nested List Weight Sum不一样的地方是，之前是传层数，现在直接传上一层整数的和
    // 每一层都加一遍上一层的整数和，比如在第三层的时候，第一层的整数和就分别在第一、二和三层都加过一遍相当于乘以3，
    // 而第二层的整数和在第二和第三层累加过，相当于乘以了2，依次类推
    // 其实应该是BFS的递归版本
    private int dfs(List<NestedInteger> nestedList, int preSum)
    {
        if(nestedList == null || nestedList.size() == 0)
            return 0;
        // 下一层遍历的list
        List<NestedInteger> nextLevel = new ArrayList<NestedInteger>();
        for(NestedInteger nint : nestedList)
        {
            // 统计这一层的所有整数和上一层的和
            if(nint.isInteger())
                preSum += nint.getInteger();
            else
                // 把list加入下一层
                nextLevel.addAll(nint.getList());
        }
        // 递归遍历，注意我们这里每层只递归依次而不是在for循环里，
        // 因为如果放在for循环里在每个list里进行递归，那这一层的整数和会在下一层里被重复累加，
        // 我们只希望这一层的和在下一层只被加一次
        return preSum + dfs(nextLevel, preSum);   
    }
}

public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public boolean verifyPreorder(int[] preorder) 
    {
        Stack<Integer> stack = new Stack<Integer>();
        // 初始化最小值为最小整数
        int min = Integer.MIN_VALUE;
        // 二叉搜索树先序遍历序列的特点是降序的部分一定是向左走的，
        // 一旦开始升序说明开始向右走了，则上一个降序的点则限定了后面的数的最小值
        for(int num : preorder)
        {
            // 违反最小值限定则是无效的
            if(num < min) 
                return false;
            // 将路径中所有小于当前的数pop出来并更新最小值，
            // 最后找到的是比num刚刚大一点的数，即num的父节点
            while(!stack.isEmpty() && num > stack.peek())
            {
                min = stack.pop();
            }
            // 将当前值push进去
            stack.push(num);
        }
        return true;
    }
}

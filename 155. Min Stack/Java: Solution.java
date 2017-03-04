public class MinStack {
    // 存入当前压入栈的元素
    Stack<Integer> stack;
    // 存可能的最小值
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() 
    {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    // 时间复杂度O(1)，空间复杂度O(n)
    public void push(int x) 
    {
        // minStack栈顶为最小元素
    	// 这里的思路是你后面可能压入比较大的元素，但是pop时肯定是比较大的元素先被pop，他们没有机会成为最小元素
    	// 所以不用关心是否把那些大的元素压入minStack
        if(minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
        stack.push(x);
    }
    
    // 时间复杂度O(1)，空间复杂度O(n)
    public void pop() 
    {
        // Stack.peek()返回的是Object，比较两个Object应该用equals方法
        if(minStack.peek().equals(stack.peek()))
            minStack.pop();
        stack.pop();
    }
    
    public int top() 
    {
        return stack.peek();    
    }
    
    public int getMin() 
    {
        return minStack.peek();    
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

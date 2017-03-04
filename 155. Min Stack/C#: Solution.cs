public class MinStack {
    Stack<int> stack;
    Stack<int> minStack;

    /** initialize your data structure here. */
    public MinStack() 
    {
        stack = new Stack<int>();
        minStack = new Stack<int>();
    }
    
    public void Push(int x) 
    {
        if(minStack.Count == 0 || x <= minStack.Peek())
            minStack.Push(x);
        stack.Push(x);
    }
    
    public void Pop() 
    {
        if(minStack.Peek().Equals(stack.Peek()))
            minStack.Pop();
        stack.Pop();
    }
    
    public int Top() 
    {
        return stack.Peek();    
    }
    
    public int GetMin() 
    {
        return minStack.Peek();    
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.Push(x);
 * obj.Pop();
 * int param_3 = obj.Top();
 * int param_4 = obj.GetMin();
 */

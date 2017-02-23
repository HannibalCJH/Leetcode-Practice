public class MyQueue {
    // 队列和栈都是顺序插入的，区别在于队列的出口方向和栈的出口方向是相反的，
    // 利用这个性质，如果我们将元素按照顺序插入栈后，再一个个弹出并反向插入另一个栈，
    // 那么这第二个栈的出口顺序就和队列是一样的了。所以我们构造两个栈，所有新加的元素都加入输入栈，
    // 一旦要出队列时，我们便将输入栈的元素都反向加入输出栈，再输出
    Stack<Integer> inputStack;
    Stack<Integer> outputStack;
    
    /** Initialize your data structure here. */
    public MyQueue() 
    {
        inputStack = new Stack<Integer>();
        outputStack = new Stack<Integer>();
    }
    
    // 时间复杂度O(1)，空间复杂度O(n)
    /** Push element x to the back of queue. */
    public void push(int x) 
    {
        // 每次把新元素push到输入栈
        inputStack.push(x);    
    }
    
    // 时间复杂度O(n)，空间复杂度O(n)
    /** Removes the element from in front of queue and returns that element. */
    public int pop() 
    {
        // 输出栈不为空就直接弹出栈顶元素即可
        if(!outputStack.isEmpty())
            return outputStack.pop();
        else
        {
            // 输出栈为空，则把输入栈的元素全部反向装填进输出栈
            while(!inputStack.isEmpty())
            {
                outputStack.push(inputStack.pop());
            }
            return outputStack.pop();
        }
    }
    // 时间复杂度O(n)，空间复杂度O(n)
    /** Get the front element. */
    public int peek() 
    {
        if(!outputStack.isEmpty())
            return outputStack.peek();
        else
        {
            while(!inputStack.isEmpty())
            {
                outputStack.push(inputStack.pop());
            }
            return outputStack.peek();
        }
    }
    // 时间复杂度O(1)，空间复杂度O(n)
    /** Returns whether the queue is empty. */
    public boolean empty() 
    {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

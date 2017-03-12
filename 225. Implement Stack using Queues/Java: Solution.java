public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() 
    {
        queue1 = new LinkedList<Integer>();   
        queue2 = new LinkedList<Integer>();
    }
    
    // 时间复杂度O(n)，空间复杂度O(n)
    // 每次只push后一个队列为空，另一个队列保存所有元素
    /** Push element x onto stack. */
    public void push(int x) 
    {
        // 两个栈都为空
        if(empty())
        {
            queue1.offer(x);
        }
        else
        {
            // 所有元素在queue1
            if(!queue1.isEmpty())
            {
                // 把当前压入的元素也就是最后进入的元素加入到空队列的头，这就是后进先出
                queue2.offer(x);
                // 把queue1中的元素全部倒入queue2中，注意倒过去以后顺序不变
                while(!queue1.isEmpty())
                {
                    queue2.offer(queue1.poll());
                }
            }
            // 所有元素在queue2
            else if(!queue2.isEmpty())
            {
                // 把当前压入的元素也就是最后进入的元素加入到空队列的头，这就是后进先出
                queue1.offer(x);
                // 把queue2中的元素全部倒入queue1中，注意倒过去以后顺序不变
                while(!queue2.isEmpty())
                {
                    queue1.offer(queue2.poll());
                }
            }
        }
    }
    
    // 时间复杂度O(1)，空间复杂度O(n)
    /** Removes the element on top of the stack and returns that element. */
    public int pop() 
    {
        if(!queue1.isEmpty())
            return queue1.poll();
        else if(!queue2.isEmpty())
            return queue2.poll();
        else
            return 0;
    }
    
    // 时间复杂度O(1)，空间复杂度O(n)
    /** Get the top element. */
    public int top() 
    {
        if(!queue1.isEmpty())
            return queue1.peek();
        else if(!queue2.isEmpty())
            return queue2.peek();
        else
            return 0;
    }
    
    // 时间复杂度O(1)，空间复杂度O(n)
    /** Returns whether the stack is empty. */
    public boolean empty() 
    {
        return queue1.isEmpty() && queue2.isEmpty();    
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

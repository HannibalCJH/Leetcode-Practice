public class Solution {
    public bool VerifyPreorder(int[] preorder) 
    {
        Stack<int> stack = new Stack<int>();
        int min = int.MinValue;
        for(int i = 0; i < preorder.Length; i++)
        {
            int num = preorder[i];
            if(num < min)
                return false;
            while(stack.Count != 0 && num > stack.Peek())
            {
                min = stack.Pop();
            }
            stack.Push(num);
        }
        return true;
    }
}

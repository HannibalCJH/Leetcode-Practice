public class Solution {
    public int EvalRPN(string[] tokens) 
    {
        if(tokens.Length == 0)
            return 0;
        
        int opr1, opr2;
        Stack<int> stack = new Stack<int>();
        for(int i = 0; i < tokens.Length; i++)
        {
            string cur = tokens[i];
            switch(cur)
            {
                case  "+":
                    opr2 = stack.Pop();
                    opr1 = stack.Pop();
                    stack.Push(opr1 + opr2); break;
                case "-":
                    opr2 = stack.Pop();
                    opr1 = stack.Pop();
                    stack.Push(opr1 - opr2); break;
                case "*":
                    opr2 = stack.Pop();
                    opr1 = stack.Pop();
                    stack.Push(opr1 * opr2); break;
                case "/":
                    opr2 = stack.Pop();
                    opr1 = stack.Pop();
                    stack.Push(opr1 / opr2); break;
                default: 
                    stack.Push(Int32.Parse(tokens[i])); break;
            }
        }
        return stack.Pop();
    }
}

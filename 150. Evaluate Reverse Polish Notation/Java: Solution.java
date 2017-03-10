public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public int evalRPN(String[] tokens) 
    {
        if(tokens.length == 0)
            return 0;
        int opr1, opr2;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++)
        {
            String cur = tokens[i];
            switch(cur)
            {
                case "+":
                    opr2 = stack.pop();
                    opr1 = stack.pop();
                    stack.push(opr1 + opr2); break;
                case "-":
                    opr2 = stack.pop();
                    opr1 = stack.pop();
                    stack.push(opr1 - opr2); break;
                case "*":
                    opr2 = stack.pop();
                    opr1 = stack.pop();
                    stack.push(opr1 * opr2); break;
                case "/":
                    opr2 = stack.pop();
                    opr1 = stack.pop();
                    stack.push(opr1 / opr2); break;
                default: 
                    stack.push(Integer.parseInt(cur));
            }
        }
        return stack.pop();
    }
}

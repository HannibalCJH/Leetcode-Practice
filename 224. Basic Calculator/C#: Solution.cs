public class Solution {
    public int Calculate(string s) 
    {
        if(s == null || s.Length == 0)
            return 0;
            
        Stack<int> stack = new Stack<int>();
        int result = 0;
        int sign = 1;
        for(int i = 0; i < s.Length; i++)
        {
            char cur = s[i];
            if(Char.IsDigit(cur))
            {
                int start = i;
                while(i + 1 < s.Length && Char.IsDigit(s[i + 1]))
                {
                    i++;
                }
                int opr = Int32.Parse(s.Substring(start, i - start + 1));
                result += sign * opr;
            }
            else if(cur == '+')
                sign = 1;
            else if(cur == '-')
                sign = -1;
            else if(cur == '(')
            {
                stack.Push(result);
                result = 0;
                stack.Push(sign);
                sign = 1;
            }
            else if(cur == ')')
            {
                result = result * stack.Pop() + stack.Pop();
            }
        }
        return result;
    }
}

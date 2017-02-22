public class Solution {
    public bool IsValid(string s) 
    {
        if(s == null || s.Length == 0)
            return true;
        
        Stack<char> stack = new Stack<char>();
        for(int i = 0; i < s.Length; i++)
        {
            char ch = s[i];
            switch(ch)
            {
                case ')':
                    if(stack.Count == 0 || stack.Peek() != '(') return false;
                    stack.Pop(); break;
                case ']':
                    if(stack.Count == 0 || stack.Peek() != '[') return false;
                    stack.Pop(); break;
                case '}':
                    if(stack.Count == 0 || stack.Peek() != '{') return false;
                    stack.Pop(); break;
                default:
                    stack.Push(ch); break;
            }
        }
        return stack.Count == 0;
    }
}

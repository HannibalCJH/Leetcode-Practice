public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public boolean isValid(String s) 
    {
        if(s == null || s.length() == 0)
            return true;
            
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++)
        {
            char cur = s.charAt(i);
            switch(cur)
            {
                case ')':
                    if(stack.isEmpty() || stack.peek() != '(') return false;
                    stack.pop(); break;
                case ']':
                    if(stack.isEmpty() || stack.peek() != '[') return false;
                    stack.pop(); break;
                case '}':
                    if(stack.isEmpty() || stack.peek() != '{') return false;
                    stack.pop(); break;
                default:
                    stack.push(cur);
            }
        }
        // 返回时判断栈是否空，不空说明没有匹配完
        return stack.isEmpty();
    }
}

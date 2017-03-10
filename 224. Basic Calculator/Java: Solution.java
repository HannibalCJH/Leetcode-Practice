public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public int calculate(String s) 
    {
        if(s == null || s.length() == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++)
        {
            // 当前的字符
            char cur = s.charAt(i);
            // 当前字符为数字
            if(Character.isDigit(cur))
            {
                int start = i;
                // 截取完整的做运算的数
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
                {
                    i++;
                }
                int sum = Integer.parseInt(s.substring(start, i + 1));
                // 注意要乘以符号位
                result += sign * sum;
            }
            else if(cur == '+')
            {
                sign = 1;
            }
            else if(cur == '-')
            {
                sign = -1;
            }
            else if(cur == '(')
            {
                // 把括号之前所有的数的和压入栈
                stack.push(result);
                // 重置result为0，开始计算括号内的数字的和
                result = 0;
                // 把括号之前的符号压入栈
                stack.push(sign);
                // 把符号重置为正
                sign = 1;
            }
            else if(cur == ')')
            {
                // 栈第一次弹出的是符号，第二次是栈之前的所有数的和
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }
}

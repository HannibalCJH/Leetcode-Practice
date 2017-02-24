public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public String simplifyPath(String path) 
    {
        int length = path.length();
        // 空路径返回"/"
        if(length == 0)
            return "/";
        // 栈里面只存目录名，不存"/"
        Stack<String> stack = new Stack<String>();
        int index = 0;
        while(index < length)
        {
            char cur = path.charAt(index);
            if(cur == '/')
            {
                int right = index + 1;
                // 搜索下一个斜杠
                while(right < length && path.charAt(right) != '/')
                {
                    right++;
                }
                // 取两个斜杠之间的字符串即目录名
                String curLevel = path.substring(index + 1, right);
                // index往前移动到下一个斜杠
                index = right;
                // 如果为空，说明是两个连续的斜杠
                if(curLevel.length() == 0)
                    continue;
                // 如果是两个点则弹出上级目录
                if(curLevel.equals(".."))
                {
                    // 如果栈为空，我们也不想把".."压入栈，所以不能直接只写一层判断，比如
                    // curLevel.equals("..") && !stack.isEmpty()，这样会把/../里的两个点压入栈
                    if(!stack.isEmpty())
                        stack.pop();
                }
                // 当级目录
                else if(curLevel.equals("."))
                    continue;
                else
                    // 把有效目录名压入栈
                    stack.push(curLevel);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        {
            sb.insert(0, "/" + stack.pop());
        }
        
        if(sb.length() == 0)
            sb.append("/");
            
        return sb.toString();
    }
}

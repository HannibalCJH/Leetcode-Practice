public class Solution {
    public string SimplifyPath(string path) 
    {
        int length = path.Length;
        if(length == 0)
            return "/";
        
        Stack<string> stack = new Stack<string>();
        int index = 0;
        while(index < length)
        {
            char cur = path[index];
            if(cur == '/')
            {
                int right = index + 1;
                while(right < length && path[right] != '/')
                {
                    right++;
                }
                string curLevel = path.Substring(index + 1, right - (index + 1));
                index = right;
                if(curLevel.Length == 0)
                    continue;
                
                if(curLevel.Equals(".."))
                {
                    if(stack.Count > 0)
                        stack.Pop();
                }
                else if(curLevel.Equals("."))
                    continue;
                else
                    stack.Push(curLevel);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(stack.Count > 0)
        {
            sb.Insert(0, "/" + stack.Pop());
        }
        
        if(sb.Length == 0)
            sb.Append("/");
        return sb.ToString();
    }
}

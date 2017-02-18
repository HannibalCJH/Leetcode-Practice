public class Solution {
    public IList<string> RemoveInvalidParentheses(string s) 
    {
        List<string> result = new List<string>();
        if(s == null || s.Length == 0)
        {
            result.Add("");
            return result;
        }
        Remove(result, s, new char[] {'(', ')'}, 0, 0);
        return result;
    }
    
    private void Remove(List<string> result, string str, char[] par, int last_i, int last_j)
    {
        int stack = 0;
        int i = last_i;
        for(; i < str.Length; i++)
        {
            if(str[i] == par[0])
                stack++;
            if(str[i] == par[1])
                stack--;
            if(stack < 0)
            {
                for(int j = last_j; j <= i; j++)
                {
                    if(str[j] == par[1] && (j == last_j || str[j-1] != par[1]))
                        Remove(result, str.Substring(0, j) + str.Substring(j + 1), par, i, j);
                }
                return;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int k = str.Length - 1; k >= 0; k--)
            sb.Append(str[k]);
        string rs = sb.ToString();
        
        if(par[0] == '(')
            Remove(result, rs, new char[] {')', '('}, 0, 0);
        else
            result.Add(rs);
    }
}

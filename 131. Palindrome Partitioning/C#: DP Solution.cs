public class Solution {
    IList<IList<string>> result;
    
    public IList<IList<string>> Partition(string s) 
    {
        result = new List<IList<string>>();
        if(s == null || s.Length == 0)
            return result;
            
        bool[,] dp = new bool[s.Length,s.Length];    
        for(int i = 0; i < s.Length; i++)
        {
            for(int j = i; j < s.Length; j++)
            {
                dp[i,j] = IsPalindrome(s, i, j);
            }
        }
        
        DFS(new List<string>(), s, dp, 0);
        return result;
    }
    
    private void DFS(List<string> str, string s, bool[,] dp, int start)
    {
        if(start == s.Length)
        {
            result.Add(new List<string>(str));
            return;
        }
        
        for(int i = start; i < s.Length; i++)
        {
            if(dp[start,i])
            {
                // 加到末尾用Insert
                str.Add(s.Substring(start, i - start + 1));
                // 递归
                DFS(str, s, dp, i + 1);
                // 回溯
                str.RemoveAt(str.Count - 1);
            }
        }
    }
    
    private bool IsPalindrome(string str, int left, int right)
    {
        while(left <= right)
        {
            if(str[left++] != str[right--])
            {
                return false;
            }
        }
        return true;
    }
}

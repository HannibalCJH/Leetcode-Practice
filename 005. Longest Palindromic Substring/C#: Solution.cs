public class Solution {
    public string LongestPalindrome(string s) 
    {
        if(s == null || s.Length == 0)
            return "";
        
        StringBuilder result = new StringBuilder(s.Substring(0, 1));
        for(int i = 0; i < s.Length - 1; i++)
        {
            string cur = ExpandFromCenter(s, i, i);
            if(cur.Length > result.Length)
                result = new StringBuilder(cur);
            
            cur = ExpandFromCenter(s, i, i + 1);
            if(cur.Length > result.Length)
                result = new StringBuilder(cur);
        }
        return result.ToString();
    }
    
    private string ExpandFromCenter(string str, int left, int right)
    {
        while(left >= 0 && right < str.Length && str[left] == str[right])
        {
            left--;
            right++;
        }
        return str.Substring(left + 1, right - left - 1);
    }
}

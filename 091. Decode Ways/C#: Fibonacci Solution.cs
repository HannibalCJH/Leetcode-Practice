public class Solution {
    public int NumDecodings(string s) 
    {
        if(s == null || s.Length == 0 || s[0] == '0')
            return 0;
        int first = 1, second = 1;
        int cur = 1;
        for(int i = 2; i < s.Length + 1; i++)
        {
            cur = 0;
            if(Int32.Parse(s.Substring(i - 2, 2)) >= 10 && Int32.Parse(s.Substring(i - 2, 2)) <= 26)
                cur += first;
            if(Int32.Parse(s.Substring(i - 1, 1)) > 0)
                cur += second;
            first = second;
            second = cur;
        }
        return cur;
    }
}

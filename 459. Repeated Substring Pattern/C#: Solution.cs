public class Solution {
    public bool RepeatedSubstringPattern(string s) 
    {
        if(s == null || s.Length == 0)
            return false;
        
        int length = s.Length;
        char start = s[0];
        int lastIndex = 0;
        StringBuilder sb = new StringBuilder();
        while(lastIndex < length / 2)
        {
            int next = s.IndexOf(start, lastIndex + 1);
            if(next == -1)
                break;
            if(length % next == 0)
            {
                sb = new StringBuilder();
                string pattern = s.Substring(0, next);
                int times = length / next;
                for(int i = 0; i < times; i++)
                {
                    sb.Append(pattern);
                }
                if(s.Equals(sb.ToString()))
                    return true;
            }
            lastIndex = next;
        }
        return false;
    }
}

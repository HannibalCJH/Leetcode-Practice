public class Solution {
    public string MinWindow(string s, string t) 
    {
        int[] map = new int[256];
        int start = 0, end = 0, count = 0;
        for(int i = 0; i < t.Length; i++)
            map[t[i]]++;
        int minLength = Int32.MaxValue;
        int minStart = 0;
        
        while(end < s.Length)
        {
            if(map[s[end]] > 0)
            {
                count++;
            }
            
            map[s[end]]--;
            while(count == t.Length)
            {
                if(end - start + 1 < minLength)
                {
                    minLength = end - start + 1;
                    minStart = start;
                }
                
                if(map[s[start]] == 0)
                {
                    count--;
                }
                map[s[start++]]++;
            }
            end++;
        }
        
        if(minStart + minLength > s.Length)
            return "";
        return s.Substring(minStart, minLength);
    }
}

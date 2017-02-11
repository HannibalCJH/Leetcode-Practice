public class Solution {
    public string MinWindow(string s, string t) 
    {
        Dictionary<char, int> map = new Dictionary<char, int>();
        int start = 0, end = 0, count = 0;
        for(int i = 0; i < t.Length; i++)
        {
            if(!map.ContainsKey(t[i]))
                map.Add(t[i], 1);
            else
                map[t[i]]++;
        }
        int minLength = Int32.MaxValue;
        int minStart = 0;
        
        while(end < s.Length)
        {
            char cur = s[end];
            if(map.ContainsKey(cur))
            {
                if(map[cur] > 0)
                    count++;
                map[cur]--;
            }
            
            while(count == t.Length)
            {
                if(end - start + 1 < minLength)
                {
                    minLength = end - start + 1;
                    minStart = start;
                }
                
                char startChar = s[start];
                
                if(map.ContainsKey(startChar))
                {
                    if(map[startChar] == 0)
                        count--;
                    map[startChar]++;
                }
                start++;
            }
            end++;
        }
        if(minStart + minLength > s.Length)
            return "";
        return s.Substring(minStart, minLength);
    }
}

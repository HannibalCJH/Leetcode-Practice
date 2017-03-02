public class Solution {
    public IList<int> FindAnagrams(string s, string p) 
    {
        IList<int> result = new List<int>();
        Dictionary<char, int> map = new Dictionary<char, int>();
        int start = 0, end = 0, count = 0;
        for(int i = 0; i < p.Length; i++)
        {
            if(!map.ContainsKey(p[i]))
                map.Add(p[i], 1);
            else
                map[p[i]]++;
        }
        
        while(end < s.Length)
        {
            char cur = s[end];
            if(map.ContainsKey(cur))
            {
                if(map[cur] > 0)
                    count++;
                map[cur]--;
            }
            
            while(count == p.Length)
            {
                if(end - start + 1 == p.Length)
                {
                    result.Add(start);
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
        return result;
    }
}

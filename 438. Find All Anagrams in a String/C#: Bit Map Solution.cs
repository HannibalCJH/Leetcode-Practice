public class Solution {
    public IList<int> FindAnagrams(string s, string p) 
    {
        IList<int> result = new List<int>();
        if(s == null || s.Length == 0)
            return result;
        
        int[] map = new int[128];
        for(int i = 0; i < p.Length; i++)
            map[p[i]]++;
        
        int start = 0, end = 0;
        int count = 0;
        while(end < s.Length)
        {
            char cur = s[end];
            if(map[cur] > 0)
            {
                count++;
            }
            
            map[cur]--;
            while(count == p.Length)
            {
                if(end - start + 1 == p.Length)
                {
                    result.Add(start);
                }
                
                if(map[s[start]] == 0)
                {
                    count--;
                }
                map[s[start++]]++;
            }
            end++;
        }
        return result;
    }
}

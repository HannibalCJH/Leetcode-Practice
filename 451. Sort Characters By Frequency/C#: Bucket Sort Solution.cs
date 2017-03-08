public class Solution {
    public string FrequencySort(string s) 
    {
        Dictionary<char, int> map = new Dictionary<char, int>();
        for(int i = 0; i < s.Length; i++)
        {
            char cur = s[i];
            if(map.ContainsKey(cur))
            {
                map[cur]++;
            }
            else
            {
                map.Add(cur, 1);
            }
        }

        List<char>[] buckets = new List<char>[s.Length + 1];
        foreach(char key in map.Keys)
        {
            int freq = map[key];
            if(buckets[freq] == null)
            {
                buckets[freq] = new List<char>();
            }
            buckets[freq].Add(key);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = buckets.Length - 1; i >= 0; i--)
        {
            if(buckets[i] != null)
            {
                foreach(char cur in buckets[i])
                {
                    for(int j = 0; j < i; j++)
                    {
                        sb.Append(cur);
                    }
                }
            }
        }
        return sb.ToString();
    }
}

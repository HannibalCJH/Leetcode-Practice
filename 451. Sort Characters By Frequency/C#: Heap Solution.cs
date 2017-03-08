class PairComparer : IComparer<KeyValuePair<char, int>>
{
    // 关键部分，与Java的PriorityQueue不同，C#中SortedSet实现Set接口不支持有相同的结果，这边需要改进比较器
    // 1.当两个字符出现的次数不一样时，直接比较Value就行
    // 2.当两个字符出现的次数一样时，我们比较Key，因为Key即代表的字符肯定不同，所以我们能保证把所有的字符都存进了SortedSet
    public int Compare(KeyValuePair<char, int> l1, KeyValuePair<char, int> l2)
    {
        if(l1.Value == l2.Value)
            return l1.Key - l2.Key;
        else
            return l1.Value - l2.Value;
    }
}

public class Solution {
    public string FrequencySort(string s) 
    {
        Dictionary<char, int> letters = new Dictionary<char, int>();
        for(int i = 0; i < s.Length; i++)
        {
            char cur = s[i];
            if(letters.ContainsKey(cur))
            {
                letters[cur]++;
            }
            else
            {
                letters.Add(cur, 1);
            }
        }
        
        SortedSet<KeyValuePair<char, int>> heap = new SortedSet<KeyValuePair<char, int>>(new PairComparer());
        foreach(KeyValuePair<char, int> pair in letters)
        {
            heap.Add(pair);
        }
        
        
        StringBuilder sb = new StringBuilder();
        while(heap.Count > 0)
        {
            KeyValuePair<char, int> cur = heap.Max;
            char ch = cur.Key;
            for(int i = 0; i < cur.Value; i++)
            {
                sb.Append(ch);
            }
            heap.Remove(heap.Max);
        }
        return sb.ToString();
    }
}

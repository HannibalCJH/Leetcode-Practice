class Letter
{
    public char letter;
    public int count;
    public Letter(char letter, int count)
    {
        this.letter = letter;
        this.count = count;
    }
}

class LetterComparer : IComparer<Letter>
{
    // 关键部分，与Java的PriorityQueue不同，C#中SortedSet实现Set接口不支持有相同的结果，这边需要改进比较器
    // 1.当两个字符出现的次数不一样时，直接比较count就行
    // 2.当两个字符出现的次数一样时，我们比较letter，因为letter即代表的字符肯定不同，所以我们能保证把所有的字符都存进了SortedSet
    public int Compare(Letter l1, Letter l2)
    {
        if(l1.count == l2.count)
            return l1.letter - l2.letter;
        else
            return l1.count - l2.count;
    }
}

public class Solution {
    public string FrequencySort(string s) 
    {
        Dictionary<char, Letter> letters = new Dictionary<char, Letter>();
        for(int i = 0; i < s.Length; i++)
        {
            char cur = s[i];
            if(letters.ContainsKey(cur))
            {
                letters[cur].count++;
            }
            else
            {
                letters.Add(cur, new Letter(cur, 1));
            }
        }
        
        SortedSet<Letter> heap = new SortedSet<Letter>(new LetterComparer());
        foreach(char key in letters.Keys)
        {
            heap.Add(letters[key]);
        }
        
        
        StringBuilder sb = new StringBuilder();
        while(heap.Count > 0)
        {
            Letter cur = heap.Max;
            char ch = cur.letter;
            for(int i = 0; i < cur.count; i++)
            {
                sb.Append(ch);
            }
            heap.Remove(heap.Max);
        }
        return sb.ToString();
    }
}

public class WordDistance {
    Dictionary<string, List<int>> map;

    public WordDistance(string[] words) 
    {
        map = new Dictionary<string, List<int>>();
        for(int i = 0; i < words.Length; i++)
        {
            if(!map.ContainsKey(words[i]))
            {
                map.Add(words[i], new List<int>());
            }
            map[words[i]].Add(i);
        }
    }
    
    public int Shortest(string word1, string word2) 
    {
        List<int> list1 = map[word1];
        List<int> list2 = map[word2];
        int i = 0, j = 0;
        int minDist = Int32.MaxValue;
        while(i < list1.Count && j < list2.Count)
        {
            int idx1 = list1[i], idx2 = list2[j];
            if(idx1 < idx2)
            {
                i++;
            }
            else
            {
                j++;
            }
            minDist = Math.Min(minDist, Math.Abs(idx1 - idx2));
        }
        return minDist;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.Shortest(word1,word2);
 */

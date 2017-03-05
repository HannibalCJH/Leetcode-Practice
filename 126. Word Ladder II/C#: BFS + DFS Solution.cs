public class Solution {
    public IList<IList<string>> FindLadders(string beginWord, string endWord, IList<string> wordList) 
    {
        HashSet<string> dict = new HashSet<string>();
        foreach(string word in wordList)
        {
            dict.Add(word);
        }
        
        IList<IList<string>> result = new List<IList<string>>();
        Dictionary<string, List<string>> map = new Dictionary<string, List<string>>();
        Dictionary<string, int> distance = new Dictionary<string, int>();
        
        BFS(beginWord, endWord, dict, map, distance);
        List<string> path = new List<string>();
        DFS(result, path, endWord, beginWord, map, distance);
        return result;
    }
    
    private void DFS(IList<IList<string>> result, List<string> path, string cur, string beginWord, Dictionary<string, List<string>> map, Dictionary<string, int> distance)
    {
        path.Add(cur);
        if(cur.Equals(beginWord))
        {
            path.Reverse();
            result.Add(new List<string>(path));
            path.Reverse();
        }
        else if(map.ContainsKey(cur))
        {
            foreach(string next in map[cur])
            {
                if(distance.ContainsKey(next) && distance[next] + 1 == distance[cur])
                {
                    DFS(result, path, next, beginWord, map, distance);
                }
            }
        }
        path.RemoveAt(path.Count - 1);
    }
    
    private void BFS(string beginWord, string endWord, HashSet<string> dict, Dictionary<string, List<string>> map, Dictionary<string, int> distance)
    {
        Queue<string> queue = new Queue<string>();
        queue.Enqueue(beginWord);
        distance.Add(beginWord, 0);
        foreach(string word in dict)
        {
            map.Add(word, new List<string>());
        }
        
        while(queue.Count > 0)
        {
            string word = queue.Dequeue();
            int length = distance[word] + 1;
            foreach(string nextWord in GetNextWords(word, dict))
            {
                map[nextWord].Add(word);
                if(!distance.ContainsKey(nextWord))
                {
                    distance.Add(nextWord, length);
                    queue.Enqueue(nextWord);
                }
            }
        }
    }
    
    private List<string> GetNextWords(string word, HashSet<string> dict)
    {
        List<string> nextWords = new List<string>();
        for(int i = 0; i < word.Length; i++)
        {
            for(char j = 'a'; j <= 'z'; j++)
            {
                if(j == word[i])
                    continue;
                    
                StringBuilder nextWord = new StringBuilder(word);
                nextWord[i] = j;
                if(dict.Contains(nextWord.ToString()))
                    nextWords.Add(nextWord.ToString());
            }
        }
        return nextWords;
    }
}

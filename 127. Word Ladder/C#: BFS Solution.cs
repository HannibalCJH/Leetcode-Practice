public class Solution {
    public int LadderLength(string beginWord, string endWord, IList<string> wordList) 
    {
        if(beginWord.Equals(endWord))
            return 1;
            
        HashSet<string> dict = new HashSet<string>();
        foreach(string word in wordList)
        {
            dict.Add(word);
        }
        
        int length = 1;
        Queue<string> queue = new Queue<string>();
        HashSet<string> set = new HashSet<string>();
        queue.Enqueue(beginWord);
        set.Add(beginWord);
        
        while(queue.Count > 0)
        {
            length++;
            int size = queue.Count;
            for(int i = 0; i < size; i++)
            {
                string word = queue.Dequeue();
                foreach(string nextWord in GetNextWords(word, dict))
                {
                    if(!set.Contains(nextWord))
                    {
                        if(nextWord.Equals(endWord))
                            return length;
                            
                        queue.Enqueue(nextWord);
                        set.Add(nextWord);
                    }
                }
            }
        }
        return 0;
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

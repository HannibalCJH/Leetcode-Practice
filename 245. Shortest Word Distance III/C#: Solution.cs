public class Solution {
    public int ShortestWordDistance(string[] words, string word1, string word2) 
    {
        int idx1 = -1, idx2 = -1;
        int minDist = words.Length;
        bool equal = word1.Equals(word2);
        for(int i = 0; i < words.Length; i++)
        {
            if(words[i].Equals(word1))
            {
                idx1 = i;
                if(idx2 >= 0)
                    minDist = Math.Min(minDist, idx1 - idx2);
            }
            
            if(words[i].Equals(word2))
            {
                idx2 = i;
                if(idx1 >= 0 && !equal)
                    minDist = Math.Min(minDist, idx2 - idx1);
            }
        }
        return minDist;
    }
}

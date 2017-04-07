public class Solution {
    public int ShortestDistance(string[] words, string word1, string word2) 
    {
        int minDist = words.Length;
        int idx1 = -1, idx2 = -1;
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
                if(idx1 >= 0)
                    minDist = Math.Min(minDist, idx2 - idx1);
            }
        }
        return minDist;
    }
}

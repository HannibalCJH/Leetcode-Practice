public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public int shortestDistance(String[] words, String word1, String word2) 
    {
        // 初始化最小长度为数组的长度
        int minDist = words.length;
        int idx1 = -1, idx2 = -1;
        for(int i = 0; i < words.length; i++)
        {
            // 当前单词等于word1或者word2时，计算一下长度
            if(words[i].equals(word1))
            {
                idx1 = i;
                if(idx2 >= 0)
                    minDist = Math.min(minDist, idx1 - idx2);
            }
            if(words[i].equals(word2))
            {
                idx2 = i;
                if(idx1 >= 0)
                    minDist = Math.min(minDist, idx2 - idx1);
            }
        }
        return minDist;
    }
}

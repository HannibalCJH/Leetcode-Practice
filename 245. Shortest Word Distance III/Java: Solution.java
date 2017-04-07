public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public int shortestWordDistance(String[] words, String word1, String word2) 
    {
        // 初始化最小长度为数组的长度
        int minDist = words.length;
        int idx1 = -1, idx2 = -1;
        // 标记两个单词是否相等
        boolean equal = word1.equals(word2);
        
        // 唯一的不同之处在于当两个数相同，我们要保持idx1和idx2在一次循环以后是相等的，都指向上一次相同单词的位置，
        // 这样我们只需要在判断word1的时候比较一下更新后的idx1和指向上一次相同单词的idx2之间的距离，然后再同步更新idx2和idx1一致，
        // 但是跳过word2里的minDist的赋值就行
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
                // 两个单词如果相等那就不用再次比较，不然会是0
                if(idx1 >= 0 && !equal)
                    minDist = Math.min(minDist, idx2 - idx1);
            }
        }
        return minDist;
    }
}

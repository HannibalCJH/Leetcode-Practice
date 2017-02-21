public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public int firstUniqChar(String s) 
    {
        int[] freq = new int[26];
        // 第一遍记录所有字母出现的频率
        for(int i = 0; i < s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        // 第二遍找到最早的频率为1的字母，返回其下标
        for(int i = 0; i < s.length(); i++)
            if(freq[s.charAt(i) - 'a'] == 1)
                return i;
                
        return -1;
    }
}

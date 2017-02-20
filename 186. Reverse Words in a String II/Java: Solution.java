public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public void reverseWords(char[] s) 
    {
        // 反转整个字符串
        reverse(s, 0, s.length - 1);
        int left = 0, right;
        // 注意right的有边界为s.length + 1，我们要包含最后一个单词的情况
        for(right = 0; right < s.length + 1; right++)
        {
            // 1. 跳过所有字母，直到找到空格说明找到一个单词的结尾
            // 2. right == s.length，即已经遍历完字符串，但是因为末尾没有空格，所以没有这个条件会导致最后一个单词不会反转回来
            if(right == s.length || s[right] == ' ')
            {
                // 反转这个单词
                reverse(s, left, right - 1);
                left = right + 1;
            }
        }
    }
    
    // 反转字符串
    private void reverse(char[] s, int left, int right)
    {
        while(left < right)
        {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}

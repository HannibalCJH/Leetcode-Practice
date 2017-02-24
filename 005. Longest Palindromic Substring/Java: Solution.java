public class Solution {
    // 时间复杂度O(n^2)，空间复杂度O(1)
    public String longestPalindrome(String s) 
    {
        if(s == null || s.length() == 0)
            return "";
        
        // 初始化结果为第一个字符，当s只有一个字符比如"a"，不会进入下面的for循环
        StringBuilder result = new StringBuilder(s.substring(0, 1));
        // 注意我们每次都要取i和i+1的字符，所以for循环i小于字符串长度减1
        for(int i = 0; i < s.length() - 1; i++)
        {
            // 以一个中心点向两边扩散找
            String cur = expandFromCenter(s, i, i);
            if(cur.length() > result.length())
                result = new StringBuilder(cur);
            // 当中心两个点相同时，以两个点向两边扩散找
            cur = expandFromCenter(s, i, i + 1);
            if(cur.length() > result.length())
                result = new StringBuilder(cur);
        }
        return result.toString();
    }
    
    private String expandFromCenter(String str, int left, int right)
    {
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right))
        {
            left--;
            right++;
        }
        // 注意left和right是两个不合回文的位置，符合回文的是left+1到right-1的字符串
        return str.substring(left + 1, right);
    }
}

public class Solution {
    // 时间复杂度O(mn)，空间复杂度O(1)
    public int strStr(String haystack, String needle) 
    {
        // needle是空字符串的情况返回0
        if(needle.length() == 0)
            return 0;
        int i1 = 0, i2 = 0;
        // 保证haystack能截取的字符串长度大于等于needle的长度
        for(int start = 0; start <= haystack.length() - needle.length(); start++)
        {
            // haystack第一个字符和needle的第一个字符不一样直接跳过
            if(haystack.charAt(start) != needle.charAt(0))
                continue;
            // 记录haystack开始的位置
            i1 = start;
            // needle的指针
            i2 = 0;
            // 逐一比较字符
            while(i2 < needle.length() && haystack.charAt(i1) == needle.charAt(i2))
            {
                i1++;
                i2++;
            }
            // 如果截取长度等于needle说明找到了needle
            if(i2 == needle.length())
                return start;
        }
        return -1;
    }
}

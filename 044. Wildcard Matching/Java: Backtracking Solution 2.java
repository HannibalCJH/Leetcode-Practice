public class Solution {
    // 时间复杂度O(m+n)，空间复杂度O(1)
    public boolean isMatch(String s, String p) 
    {
        int sIndex = 0, pIndex = 0;
        int sMatch = 0, pStar = -1;
        while(sIndex < s.length())
        {
            // p还没有遍历完，s和p的对应字符相同或者p的字符为'?'
            if(pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?'))
            {
                // s和p在当前字符匹配，分别移动到下一个
                sIndex++;
                pIndex++;
            }
            // p还没有遍历完且p的当前字符是'*'
            else if(pIndex < p.length() && p.charAt(pIndex) == '*')
            {
                // 记录s字符串对应p字符串中'*'位置的下标，如果有一串'*'，
                // 那么记录的是对应第一个'*'的下标，所以sIndex本身没有往前移动，每次sMatch记录的都是相同的sIndex
                sMatch = sIndex;
                // 记录p字符串中这个'*'的下标
                pStar = pIndex++;
            }
            // p字符串已经出现过了'*'
            else if(pStar != -1)
            {
                // '*'用来对应s字符串中sMatch位置的字符，然后sMatch往前推进一位并置sIndex为sMatch
                sIndex = ++sMatch;
                // pIndex回溯到一连串'*'之后的字符
                pIndex = pStar + 1;
            }
            else
            {
                // 没有出现过'*'，无法匹配直接返回假
                return false;
            }
        }
        // s字符串匹配完成后p还没有遍历完，要保证p之后的字符都是'*'因为只有'*'能作为空字符串
        while(pIndex < p.length() && p.charAt(pIndex) == '*') pIndex++;
        return pIndex == p.length();
    }
}

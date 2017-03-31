public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public boolean isOneEditDistance(String s, String t) 
    {
        int m = s.length(), n = t.length();
        if(m == n)
            return isOneModified(s, t);
        if(m - n == 1)
            return isOneDeleted(s, t);
        if(n - m == 1)
            return isOneDeleted(t, s);
        // 长度差大于1直接返回false
        return false;
    }
    
    private boolean isOneModified(String s, String t)
    {
        // 记录有几个对应位置不同的字符
        int count = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) != t.charAt(i))
            {
                count++;
                // 不同字符的多于一个，说明不能由修改一个字符从s变到t
                if(count > 1)
                    return false;
            }
        }
        // 是否只需变动一个字符，注意如果s和t相等即count为0也是返回false
        return count == 1;
    }
    
    private boolean isOneDeleted(String longer, String shorter)
    {
        // 找到第一个不同的字符，然后较长字符串跳过这一位，看它之后的子串是不是和较短字符串从当前位置开始的子串相同
        for(int i = 0; i < shorter.length(); i++)
        {
            if(longer.charAt(i) != shorter.charAt(i))
            {
                return shorter.substring(i).equals(longer.substring(i + 1));
            }
        }
        return true;
    }
}

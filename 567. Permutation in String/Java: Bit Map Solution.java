public class Solution {
    // 思路和Minimum Window Substring一样
    // 时间复杂度O(m+n)，空间复杂度O(1)
    public boolean checkInclusion(String s1, String s2) 
    {
        // s1的长度必须要小于等于s2才有可能
        if(s1 == null || s2 == null || s1.length() > s2.length())
            return false;
            
        int[] bitmap = new int[128];
        // 记录s1中的字符和出现的次数
        for(int i = 0; i < s1.length(); i++)
        {
            bitmap[s1.charAt(i)]++;
        }
        
        int count = 0;
        int left = 0, right = 0;
        while(right < s2.length())
        {
            char cur = s2.charAt(right);
            // 有效字符，即s1中出现过的而且还没有超过出现次数的字符
            if(bitmap[cur] > 0)
            {
                count++;
            }
            bitmap[cur]--;
            
            while(count == s1.length())
            {
                // 判断是不是刚好等于s1的长度
                if(right - left + 1 == s1.length())
                    return true;
                
                char leftChar = s2.charAt(left);
                if(bitmap[leftChar] == 0)
                {
                    count--;
                }
                bitmap[leftChar]++;
                left++;
            }
            right++;
        }
        return false;
    }
}

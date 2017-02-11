public class Solution {
    // 思想和bit map一样，但是节省空间
    // 时间复杂度O(n)，空间复杂度O(m)其中m为t中不同的字符个数
    public String minWindow(String s, String t) 
    {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, count = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        for(int i = 0; i < t.length(); i++)
        {
            char cur = t.charAt(i);
            if(!map.containsKey(cur))
            {
                map.put(cur, 1);
            }
            else
                map.put(cur, map.get(cur) + 1);
        }
        
        while(end < s.length())
        {
            char cur = s.charAt(end);
            // t中有这个字符
            if(map.containsKey(cur))
            {
                if(map.get(cur) > 0)
                    count++;
                map.put(cur, map.get(cur) - 1);
            }
            
            // 找到一个符合要求的子串
            while(count == t.length())
            {
                if(end - start + 1 < minLength)
                {
                    minLength = end - start + 1;
                    minStart = start;
                }
                
                char startChar = s.charAt(start);
                // 移除左边界没有意义的字符
                if(map.containsKey(startChar))
                {
                    if(map.get(startChar) == 0)
                        count--;
                    map.put(startChar, map.get(startChar) + 1);
                }
                start++;
            }
            end++;
        }
        if(minStart + minLength > s.length())
            return "";
        return s.substring(minStart, minStart + minLength);
    }
}

public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public List<Integer> findAnagrams(String s, String p) 
    {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, count = 0;
        for(int i = 0; i < p.length(); i++)
        {
            char cur = p.charAt(i);
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
            // p中有这个字符
            if(map.containsKey(cur))
            {
                if(map.get(cur) > 0)
                    count++;
                map.put(cur, map.get(cur) - 1);
            }
            
            // 找到一个符合要求的子串
            while(count == p.length())
            {
                if(end - start + 1 == p.length())
                {
                    result.add(start);
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
        return result;
    }
}

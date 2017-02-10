public class Solution {
    // Sliding window
    // 时间复杂度O(n)，空间复杂度O(n)
    // 如果要返回这个子串，只需要用两个指针l和r分别指向longest所代表的子串左右index，每次更新即可
    public int lengthOfLongestSubstringKDistinct(String s, int k) 
    {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int longest = 0;
        for(int right = 0; right < s.length(); right++) 
        {
            char cur = s.charAt(right);
            // 检查哈希表中是否存在当前字符
            if(map.containsKey(cur))
            {
                map.put(cur, map.get(cur) + 1);
            }
            else
            {
                map.put(cur, 1);
            }
            // 当前left到right的字串包含超过k个不同字符
            // 不断地剔除左边界的字符直到left到right子串只有包括k个不同字符
            while(map.size() > k) 
            {
                // 取得字串最左边的字符
                char leftChar = s.charAt(left);
                // 哈希表有这个字符，则个数减1
                if(map.containsKey(leftChar)) 
                {
                    map.put(leftChar, map.get(leftChar) - 1);    
                    // 减到0则删除这个字符的键
                    if(map.get(leftChar) == 0) 
                    { 
                        map.remove(leftChar);
                    }
                }
                // 左边界向右移动
                left++;
            }
            // 和全局最长比较
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    } 
}

public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public int lengthOfLongestSubstring(String s) 
    {
        if(s == null || s.length() == 0)
            return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int maxLength = 0;
        while(right < s.length())
        {
            // 当前字符
            char cur = s.charAt(right);
            // 这个字符出现过
            if(map.containsKey(cur))
            {
                // 更新最大长度
                maxLength = Math.max(right - left, maxLength);
                // 往前移动left指针到上次出现这个字符的下一个位置，新的字符串的启动应该是重复字符的下标加1
                // 这里可能出现的情况是字符'a'出现了多次，但是上一次出现的位置在left的前面即left到right之中没有'a'，
                // map里有这个字符是因为很早之前出现过，这个时候就没必要移动left指针
                if(map.get(cur) >= left)
                    left = map.get(cur) + 1;
            }
            // 更新当前字符出现的上一个位置为right
            map.put(cur, right++);
        }
        // 额外判断一次，当遍历完字符串但是最后一位没有重复的情况下，我们不会进入while循环里更新长度的语句，
        // 这样最长子串可能是left到字符串末尾的情况就没有判断
        return Math.max(maxLength, right - left);
    }
}

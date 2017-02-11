public class Solution {
    // 时间复杂度O(n)，start和end指针各自最多移动s字符串的长度，
    // 注意start不是被重置为从0开始，而是从上一个start的位置开始多以只会遍历一遍s字符串
    // 空间复杂度O(n)，bit map
    public String minWindow(String s, String t) 
    {
        // bit map
        int[] map = new int[256];
        int start = 0, end = 0;
        // 全局最小长度
        int min_length = Integer.MAX_VALUE;
        // 记录t中的字符和出现的次数
        for(int i = 0; i < t.length(); i++)
            map[t.charAt(i)]++;
        int count = 0;
        int min_start = 0;
        
        // 碰到的字符都减1，对于t中不存在的字符map对应的位置都是小于等于0
        while(end < s.length())
        {
            // t字符串有这个字符
            if(map[s.charAt(end)] > 0)
            {
                // 计数器加1
                count++;
            }
            // 碰到的字符都减1
            map[s.charAt(end)]--;
            // 找到了一个子串包含所有t的字符及个数
            while(count == t.length())
            {
                // 判断是否比全局的最小长度小
                if((end - start + 1) < min_length)
                {
                    // 更新全局最小长度和这个子串的起始位置
                    min_length = end - start + 1;
                    min_start = start;
                }
                
                // 查看左边界看是不是t中存在的字符
                // end指针往右走的时候已经把一路上碰到过的t中没有的字符的计数变成了负数
                // start走的是end走过的数所以没有意义的数字的计数已经是负数而t中存在的刚好满足个数的字符被减到了0
                // 这里被跳过的还有那些t中存在的但是数量过多的字符，这些字符的计数器也已经是负数
                if(map[s.charAt(start)] == 0)
                {
                    // 计数器减1，我们跳过了一个t中存在的字符
                    // 这样会跳出while循环，开始寻找下一个子串
                    count--;
                }
                
                // end不动，start一直往右移动，跳过那些t中不存在的字符，它们没有意义但是占着长度
                // 我们要找的其实是一个左右边界都是t中包括的字符的子串，如果左边界是没有意义的字符那就应该扔掉它
                map[s.charAt(start++)]++;
            }
            // 往后找
            end++;
        }
        // 如果从记录的最小起点出发的最小长度超过了s的长度说明不存在这样的子串
        // 这个时候其实只有一种情况，即初始情况min_start = 0且min_length = Integer.MAX_VALUE
        if(min_start + min_length > s.length())
            return "";
        return s.substring(min_start, min_start + min_length);
    }
}

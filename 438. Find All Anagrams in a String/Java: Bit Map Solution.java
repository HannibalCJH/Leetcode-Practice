public class Solution {
    // 答案几乎和Minimum Window Substring一模一样，只需一点小改动
    // 时间复杂度O(n)，空间复杂度O(n)
    public List<Integer> findAnagrams(String s, String p) 
    {
        List<Integer> result = new ArrayList<Integer>();
        if(s == null || s.length() == 0)
            return result;
        // bit map
        int[] map = new int[128];
        int start = 0, end = 0;
        // 记录p中的字符和出现的次数
        for(int i = 0; i < p.length(); i++)
            map[p.charAt(i)]++;
        int count = 0;
        
        // 碰到的字符都减1，对于p中不存在的字符map对应的位置都是小于等于0
        while(end < s.length())
        {
            // p字符串有这个字符
            if(map[s.charAt(end)] > 0)
            {
                // 计数器加1
                count++;
            }
            // 碰到的字符都减1
            map[s.charAt(end)]--;
            // 找到了一个子串包含所有p的字符及个数
            while(count == p.length())
            {
                // 子串长度等于p的长度则找到一个回文子串
                if((end - start + 1 == p.length()))
                {
                    // 把这个回文子串的起点加入结果集
                    result.add(start);
                }
                
                // 查看左边界看是不是p中存在的字符
                // end指针往右走的时候已经把一路上碰到过的p中没有的字符的计数变成了负数
                // start走的是end走过的数所以没有意义的数字的计数已经是负数而p中存在的刚好满足个数的字符被减到了0
                // 这里被跳过的还有那些p中存在的但是数量过多的字符，这些字符的计数器也已经是负数
                if(map[s.charAt(start)] == 0)
                {
                    // 计数器减1，我们跳过了一个p中存在的字符
                    // 这样会跳出while循环，开始寻找下一个子串
                    count--;
                }
                
                // end不动，start一直往右移动，跳过那些p中不存在的字符，它们没有意义但是占着长度
                // 我们要找的其实是一个左右边界都是p中包括的字符的子串，如果左边界是没有意义的字符那就应该扔掉它
                map[s.charAt(start++)]++;
            }
            // 往后找
            end++;
        }
        return result;
    }
}

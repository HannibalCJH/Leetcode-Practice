public class Solution {
    // 时间复杂度O(n^2)，空间复杂度O(n)
    public boolean repeatedSubstringPattern(String s) 
    {
        if(s == null || s.length() == 0)
            return false;
        int length = s.length();
        // 首字符
        char start = s.charAt(0);
        // 首字符上次出现的位置
        int lastIndex = 0;
        StringBuilder sb = new StringBuilder();
        // 模式的长度不能超过原字符串长度的一半
        while(lastIndex < length / 2)
        {
            // 首字符下一次出现的位置
            int next = s.indexOf(start, lastIndex + 1);
            // 如果不存在跳出循环
            if(next == -1)
                break;
            // 如果从0到next-1的子串长度即next能被整个字符串长度整除，那就有可能是一个模式，不然不可能成为一个模式
            if(length % next == 0)
            {
                sb = new StringBuilder();
                // 获取这个模式
                String pattern = s.substring(0, next);
                // 需要重复的次数
                int times = length / next;
                // 根据这个可能的模式构建字符串
                for(int i = 0; i < times; i++)
                {
                    sb.append(pattern);
                }
                // 如果和原来的字符串一样则返回真
                if(s.equals(sb.toString()))
                    return true;
            }
            // 更新首字符上次出现的位置为next
            lastIndex = next;
        }
        // 没有找到匹配的模式
        return false;
    }
}

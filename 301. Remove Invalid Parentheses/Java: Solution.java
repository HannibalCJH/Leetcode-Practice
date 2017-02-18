public class Solution {
    // 时间复杂度O(n^2)，空间复杂度O(n)
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() == 0) 
        {
            result.add("");
            return result;
        }
        remove(0, 0, new char[]{'(', ')'}, s, result);
        return result;
    }

    private void remove(int last_i, int last_j, char[] cmp, String s, List<String> result) 
    {
        int stack = 0;
        int i = last_i;
        for(; i < s.length(); i++) 
        {
            char curr = s.charAt(i);
            if(curr == cmp[0])
                stack++;
            if(curr == cmp[1])
                stack--;
            if(stack < 0) 
            {   
                for(int j = last_j; j <= i; j++)
                    // 对于连续出现的重复的cmp[1]我们只需要尝试remove第一个。不然在dfs中会得到重复的结果
                    // 比如"())", remove第一个")"和第二个")"效果是一样的，这样在结果集中会加入重复的结果
                    // j == last_j 是for循环的第一个index。因为没有前缀，肯定不是重复的cmp[1]
                    // s.charAt(j - 1) != cmp[1] 是指上一个不是cmp[1]的情况才true，这样能保证不重复remove
                    if(s.charAt(j) == cmp[1] && (j == last_j || s.charAt(j - 1) != cmp[1]))
                        remove(i, j, cmp, s.substring(0, j) + s.substring(j + 1), result);
                return;
            }
        }
        // 反转字符串
        // 1. 如果之前只进行了remove右括号，则这次反转是进行remove左括号
        // 2. 如果之前左右括号都已经remove了，这次反转就是把因为进行remove左括号而反转的字符串再度反转回来
        String rs = new StringBuilder(s).reverse().toString();
        // 之前的是remove右括号，则对于反转以后的字符串进行remove左括号的处理
        if(cmp[0] == '(')
            remove(0, 0, new char[]{')', '('}, rs, result);
        else
            // 左右括号都已经remove完毕
            result.add(rs);
    }
}

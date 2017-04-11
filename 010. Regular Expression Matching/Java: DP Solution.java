public class Solution {
    // 时间复杂度O(mn)，空间复杂度O(mn)
    public boolean isMatch(String s, String p) 
    {
        if(s == null || p == null)
            return false;
        // 二维动态规划，第0行和第0列分别用来表示s和p为空字符串的情况
        boolean[][] state = new boolean[s.length() + 1][p.length() + 1];
        state[0][0] = true;
        // 初始化动归数组第0行，把所有'*'所代表的的字符都视为出现0次即跳过这个字符，我们可以了解为是s为空字符串，p需要匹配一个空字符
        // 第0列代表p为空字符串，那么对应的情况就是全都不匹配所以第0列应该都默认为false所以不用特意初始化
        // 注意dp和p的下标有位移
        for(int i = 1; i < p.length() + 1; i++) 
        {
            // 遇到'*'，p的第一个字符默认不能为*，因为它必须和前面的字母配合使用，出现在第一个没有意义
            if(p.charAt(i - 1) == '*') 
            {
                // 前一个有效元素的状态，因为'*'是和前一个字符合起来使用，所以这里讲的前一个有效字符的状态，
                // 指的是'*'所代表的前面那个字符之前的状态
                // 比如，"cb*"，我们要找的前一个有效字符状态是'c'的状态
                state[0][i] = state[0][i - 2];
            } 
        }
        // 注意dp和s还有p的下标有位移
        for(int i = 1; i < s.length() + 1; i++) 
        {
            for(int j = 1; j < p.length() + 1; j++) 
            {
                // 字符匹配或者遇到单个字符的通配符'.'
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') 
                {
                    state[i][j] = state[i - 1][j - 1];
                }
                // 遇到多字符通配符'*'
                if(p.charAt(j - 1) == '*')
                {
                    // s中的字符和'*'之前的字符不同且'*'之前的字符不是单个字符的通配符'.'，所以这个'*'所代表的字符无法匹配，
                    // 这里我们跳过'*'和它之前的字符，也就是认为'*'之前的字符出现的个数为0，直接跳过这个字符，
                    // 把state[i][j]设成p中这个字符之前的状态，即'cb*'的状态为'c'的状态，'b'认为它出现的次数为0
                    if(s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.')
                    {
                        state[i][j] = state[i][j - 2]; 
                    }
                    else
                    {
                        // 尝试匹配
                        // 1. state[i - 1][j]：'*'匹配多个重复的字符
                        // 2. state[i][j - 1]：'*'匹配单一字符
                        // 3. state[i][j - 2]：'*'之前的字符出现次数为0
                        state[i][j] = state[i - 1][j] || state[i][j - 1] || state[i][j - 2];
                    }
                }
            }
        }
        return state[s.length()][p.length()];
    }
}

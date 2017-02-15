public class Solution {
    // 类比斐波那契数列
    // 时间复杂度O(n^2)，空间复杂度O(1)
    public int numDecodings(String s) 
    {
        if(s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        // 在dp数组做法中其实我们只需要记录dp[i-2]和dp[i-1]的数就能算出dp[i]，
        // 所以可以采用类似斐波那契数列的做法，用两个变量保存字符串中1到i-2的解法和1到i-1的解法，然后类推上去
        // 初始化前两个数为1
        int first = 1, second = 1;
        // 这里要考虑到字符串是一个数"1"，那就不会进入for循环，返回应该是1
        int cur = 1;
        for(int i = 2; i < s.length() + 1; i++)
        {
            cur = 0;
            if(Integer.parseInt(s.substring(i - 2, i)) >= 10 && Integer.parseInt(s.substring(i - 2, i)) <= 26)
                cur += first;
            if(Integer.parseInt(s.substring(i - 1, i)) > 0)
                cur += second;
            first = second;
            second = cur;
        }
        return cur;
    }
}

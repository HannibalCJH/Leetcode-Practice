public class Solution {
    // 时间复杂度O(n^2 + (n^2)(2^n))，String.substring()的时间复杂度是O(n)
    // 空间复杂度O(n^2)，dp数组
    List<List<String>> result = new ArrayList<List<String>>();
    
    public List<List<String>> partition(String s) 
    {
        if(s == null || s.length() == 0)
            return result;
        // 记录从i到j的子串是不是回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 遍历所有可能的子串并记录其是不是回文
        for(int i = 0; i < s.length(); i++)
        {
            for(int j = i; j < s.length(); j++)
            {
                dp[i][j] = isPalindrome(s, i, j);
            }
        }
        dfs(new ArrayList<String>(), s, dp, 0);
        return result;
    }
    
    private void dfs(List<String> cur, String s, boolean[][] dp, int start)
    {
        if(start == s.length())
        {
            result.add(new ArrayList<String>(cur));
            return;
        }
        // 注意下标的设置
        for(int i = start; i < s.length(); i++)
        {
            // 是回文
            if(dp[start][i])
            {
                cur.add(s.substring(start, i + 1));
                dfs(cur, s, dp, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String s, int left, int right)
    {
        while(left <= right)
        {
            if(s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}

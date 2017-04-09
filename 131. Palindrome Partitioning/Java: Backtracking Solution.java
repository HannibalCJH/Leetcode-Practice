public class Solution {
    // 时间复杂度O((n^2)(2^n))，类似subsets，加上每层中有for循环和isPalindrome都是O(n)的复杂度，String.substring也是O(n)，但是它和isPalindrome
    // 的时间是相加而不是相乘
    // 时间复杂度O(n)
    List<List<String>> result;
    
    public List<List<String>> partition(String s) 
    {
        result = new ArrayList<List<String>>();
        if(s == null || s.length() == 0)
            return result;
        dfs(new ArrayList<String>(), s, 0);
        return result;
    }
    // DFS
    private void dfs(List<String> str, String s, int start)
    {
        if(start == s.length())
        {
            result.add(new ArrayList<String>(str));
            return;
        }
        
        // 每次判断从start到i的子串是不是回文
        for(int i = start; i < s.length(); i++)
        {
            // start到i的子串是一个回文
            if(isPalindrome(s, start, i))
            {
                // 加到末尾
                str.add(str.size(), s.substring(start, i + 1));
                // 递归
                dfs(str, s, i + 1);
                // 回溯
                str.remove(str.size() - 1);
            }
        }
    }
    // 判断回文
    private boolean isPalindrome(String str, int left, int right)
    {
        while(left <= right)
        {
            if(str.charAt(left++) != str.charAt(right--))
            {
                return false;
            }
        }
        return true;
    }
}

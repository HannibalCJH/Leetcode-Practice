public class Solution {
    // 时间复杂度为O(n*(m^n))，假设平均每个数字代表m个字母, 给定的数字序列digits长度为n
    // 空间复杂度O(n)，递归栈空间，n为digits长度
    String[] keyPad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) 
    {
        if(digits == null || digits.length() == 0)
            return new ArrayList<String>();
        
        List<String> result = new ArrayList<String>();
        helper(result, digits, "", 0);
        return result;
    }
    
    private void helper(List<String> result, String digits, String cur, int step)
    {
        if(step == digits.length())
        {
            result.add(cur);
            return;
        }
        // 取数字对应的字母表
        String letters = keyPad[digits.charAt(step) - '0'];
        // 递归并回溯
        for(int i = 0; i < letters.length(); i++)
            helper(result, digits, cur + letters.charAt(i), step + 1);
    }
}

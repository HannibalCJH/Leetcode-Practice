public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1);
    public int titleToNumber(String s) 
    {
        int sum = 0;
        int factor = 1;
        for(int i = s.length() - 1; i >= 0; i--)
        {
            // 示例算式: 'B'*26^3 + 'D'*26^2 + 'A'*26 + 'E'*26^0; 
            sum += factor * (s.charAt(i) - 'A' + 1);
            factor *= 26;
        }
        return sum;
    }
}

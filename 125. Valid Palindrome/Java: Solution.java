public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public boolean isPalindrome(String s) 
    {
        if(s == null || s.length() == 0)
            return true;
            
        int left = 0, right = s.length() - 1;
        while(left <= right)
        {
            // 转换成小写
            char lChar = Character.toLowerCase(s.charAt(left)), rChar = Character.toLowerCase(s.charAt(right));
            if(!Character.isLetterOrDigit(lChar))
            {
                left++;
            }
            else if(!Character.isLetterOrDigit(rChar))
            {
                right--;
            }
            else
            {
                if(lChar == rChar)
                {
                    left++;
                    right--;
                }
                else
                    return false;
            }
        }
        return true;
    }
}

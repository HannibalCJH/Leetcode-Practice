public class Solution {
    public bool IsPalindrome(string s) 
    {
        if(s == null || s.Length == 0)
            return true;
        
        int left = 0, right = s.Length - 1;
        while(left < right)
        {
            char lChar = s[left], rChar = s[right];
            if(!Char.IsLetterOrDigit(lChar))
            {
                left++;
            }
            else if(!Char.IsLetterOrDigit(rChar))
            {
                right--;
            }
            else
            {
                if(Char.ToLower(lChar) == Char.ToLower(rChar))
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

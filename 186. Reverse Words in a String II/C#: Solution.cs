public class Solution {
    public void ReverseWords(char[] s) 
    {
        Reverse(s, 0, s.Length - 1);
        
        int left = 0, right;
        for(right = 0; right < s.Length + 1; right++)
        {
            if(right == s.Length || s[right] == ' ')
            {
                Reverse(s, left, right - 1);
                left = right + 1;
            }
        }
    }
    
    private void Reverse(char[] s, int left, int right)
    {
        while(left < right)
        {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}

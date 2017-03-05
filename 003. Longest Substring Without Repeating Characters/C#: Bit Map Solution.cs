public class Solution {
    public int LengthOfLongestSubstring(string s) 
    {
        if(s == null || s.Length == 0)
            return 0;
        
        int[] bitmap = new int[128];
        for(int i = 0; i < bitmap.Length; i++)
        {
            bitmap[i] = -1;
        }
        int left = 0, right = 0;
        int maxLength = 0;
        while(right < s.Length)
        {
            char cur = s[right];
            maxLength = Math.Max(right - left, maxLength);
            if(bitmap[cur] >= left)
                left = bitmap[cur] + 1;
            bitmap[cur] = right++;
        }
        return Math.Max(right - left, maxLength);
    }
}

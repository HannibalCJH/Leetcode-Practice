public class Solution {
    public int LengthOfLongestSubstring(string s) 
    {
        if(s == null || s.Length == 0)
            return 0;
        
        Dictionary<char, int> map = new Dictionary<char, int>();
        int left = 0, right = 0;
        int maxLength = 0;
        while(right < s.Length)
        {
            char cur = s[right];
            if(map.ContainsKey(cur))
            {
                maxLength = Math.Max(right - left, maxLength);
                if(map[cur] >= left)
                    left = map[cur] + 1;
                map[cur] = right;
            }
            else
            {
                map.Add(cur, right);
            }
            right++;
        }
        return Math.Max(maxLength, right - left);
    }
}

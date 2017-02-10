public class Solution {
    // Sliding window
    public int LengthOfLongestSubstringKDistinct(string s, int k) 
    {
        Dictionary<char, int> map = new Dictionary<char, int>();
        int left = 0;
        int longest = 0;
        for(int right = 0; right < s.Length; right++)
        {
            char cur = s[right];
            if(map.ContainsKey(cur))
            {
                map[cur]++;
            }
            else
            {
                map.Add(cur, 1);
            }
            
            while(map.Count > k)
            {
                char leftChar = s[left];
                if(map.ContainsKey(leftChar))
                {
                    map[leftChar]--;
                    if(map[leftChar] == 0)
                    {
                        map.Remove(leftChar);
                    }
                }
                left++;
            }
            
            longest = Math.Max(longest, right - left + 1);
        }
        return longest;
    }
}

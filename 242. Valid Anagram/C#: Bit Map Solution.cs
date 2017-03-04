public class Solution {
    public bool IsAnagram(string s, string t) 
    {
        if(s.Length != t.Length)
            return false;
        
        int[] bitmap = new int[26];
        for(int i = 0; i < s.Length; i++)
        {
            bitmap[s[i] - 'a']++;
            bitmap[t[i] - 'a']--;
        }
        
        for(int i = 0; i < 26; i++)
            if(bitmap[i] != 0)
                return false;
        return true;
    }
}

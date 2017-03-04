public class Solution {
    // Bitmap
    // 时间复杂度O(n)，空间复杂度O(1)
    public boolean isAnagram(String s, String t) 
    {
        if(s.length() != t.length())
            return false;
        
        int[] bitmap = new int[26];
        for(int i = 0; i < s.length(); i++)
        {
            bitmap[s.charAt(i) - 'a']++;
            bitmap[t.charAt(i) - 'a']--;
        }
        
        for(int i = 0; i < 26; i++)
            if(bitmap[i] != 0)
                return false;
        return true;
    }
}

public class Solution {
    public bool IsOneEditDistance(string s, string t) 
    {
        int m = s.Length, n = t.Length;
        if(m == n)
            return IsOneModified(s, t);
        if(m - n == 1)
            return IsOneDeleted(s, t);
        if(n - m == 1)
            return IsOneDeleted(t, s);
        return false;
    }
    
    private bool IsOneModified(string s, string t)
    {
        int count = 0;
        for(int i = 0; i < s.Length; i++)
        {
            if(s[i] != t[i])
            {
                count++;
                if(count > 1)
                    return false;
            }
        }
        return count == 1;
    }
    
    private bool IsOneDeleted(string longer, string shorter)
    {
        for(int i = 0; i < shorter.Length; i++)
        {
            if(longer[i] != shorter[i])
            {
                return shorter.Substring(i).Equals(longer.Substring(i + 1));
            }
        }
        return true;
    }
}

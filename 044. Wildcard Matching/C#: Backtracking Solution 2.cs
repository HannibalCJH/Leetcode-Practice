public class Solution {
    public bool IsMatch(string s, string p) 
    {
        int sIndex = 0, pIndex = 0;
        int sMatch = 0, pStar = -1;
        while(sIndex < s.Length)
        {
            if(pIndex < p.Length && (s[sIndex] == p[pIndex] || p[pIndex] == '?'))
            {
                sIndex++;
                pIndex++;
            }
            else if(pIndex < p.Length && p[pIndex] == '*')
            {
                sMatch = sIndex;
                pStar = pIndex++;
            }
            else if(pStar != -1)
            {
                sIndex = ++sMatch;
                pIndex = pStar + 1;
            }
            else
            {
                return false;
            }
        }
        while(pIndex < p.Length && p[pIndex] == '*') pIndex++;
        return pIndex == p.Length;
    }
}

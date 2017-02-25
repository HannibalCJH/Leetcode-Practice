public class Solution {
    public int StrStr(string haystack, string needle) 
    {
        if(needle.Length == 0)
            return 0;
        int i1 = 0, i2 = 0;
        for(int start = 0; start <= haystack.Length - needle.Length; start++)
        {
            if(haystack[start] != needle[0])
                continue;
            i1 = start;
            i2 = 0;
            while(i2 < needle.Length && haystack[i1] == needle[i2])
            {
                i1++;
                i2++;
            }
            if(i2 == needle.Length)
                return start;
        }
        return -1;
    }
}

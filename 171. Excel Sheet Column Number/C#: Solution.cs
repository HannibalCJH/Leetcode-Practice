public class Solution {
    public int TitleToNumber(string s) 
    {
        int sum = 0;
        int factor = 1;
        for(int i = s.Length - 1; i >= 0; i--)
        {
            sum += factor * (s[i] - 'A' + 1);
            factor *= 26;
        }
        return sum;
    }
}

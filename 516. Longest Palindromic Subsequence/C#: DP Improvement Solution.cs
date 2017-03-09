public class Solution {
    public int LongestPalindromeSubseq(string s) 
    {
        int n = s.Length;
        int[] row = new int[n];
        int bottomLeft = 0;
        for(int i = n - 1; i >= 0; i--)
        {
            bottomLeft = row[i];
            row[i] = 1;
            for(int j = i + 1; j < n; j++)
            {
                int temp = row[j];
                if(s[i] == s[j])
                    row[j] = bottomLeft + 2;
                else
                    row[j] = Math.Max(row[j], row[j - 1]);
                bottomLeft = temp;
            }
        }
        return row[n - 1];
    }
}

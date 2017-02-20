public class Solution {
    public string ReverseWords(string s) 
    {
        if(s == null || s.Length == 0)
            return s;
        
        string[] strArray = s.Trim().Split(new char[]{' '}, StringSplitOptions.RemoveEmptyEntries);
        StringBuilder sb = new StringBuilder();
        for(int i = strArray.Length - 1; i >= 0; i--)
        {
            string word = strArray[i];
            if(i == 0)
                sb.Append(word);
            else
                sb.Append(word + " ");
        }
        return sb.ToString();
    }
}

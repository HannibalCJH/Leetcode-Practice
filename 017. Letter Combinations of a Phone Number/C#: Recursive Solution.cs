public class Solution {
    string[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public IList<string> LetterCombinations(string digits) 
    {
        if(digits == null || digits.Length == 0)
            return new List<string>();
        IList<string> result = new List<string>();
        DFS(result, digits, "", 0);
        return result;
    }
    
    private void DFS(IList<string> result, string digits, string cur, int step)
    {
        if(step == digits.Length)
        {
            result.Add(cur);
            return;
        }
        
        string letters = keypad[digits[step] - '0'];
        for(int i = 0; i < letters.Length; i++)
            DFS(result, digits, cur + letters[i], step + 1);
    }
}

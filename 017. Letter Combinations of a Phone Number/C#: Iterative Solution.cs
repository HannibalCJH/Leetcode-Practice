public class Solution {
    string[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public IList<string> LetterCombinations(string digits) 
    {
        if(digits == null || digits.Length == 0)
            return new List<string>();
        List<string> result = new List<string>();
        Queue<string> queue = new Queue<string>();
        queue.Enqueue("");
        for(int i = 0; i < digits.Length; i++)
        {
            string letters = keypad[digits[i] - '0'];
            int size = queue.Count;
            for(int j = 0; j < size; j++)
            {
                string cur = queue.Dequeue();
                for(int k = 0; k < letters.Length; k++)
                {
                    queue.Enqueue(cur + letters[k]);
                }
            }
        }
        result.AddRange(queue);
        return result;
    }
}

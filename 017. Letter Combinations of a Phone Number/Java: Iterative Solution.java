public class Solution {
    // BFS遍历
    // 时间复杂度O(n*(m^n))，m为单词平均长度，n为数字个数。第一层循环为n，第二层循环每次乘以m，共有m^n，第三层为m
    // 所以应该是O(n*(m^(n+1))) ~ O(n*(m^n))
    // 空间复杂度O(m^n)
    String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) 
    {
        if(digits == null || digits.length() == 0)
            return new ArrayList<String>();
        List<String> result = new ArrayList<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer("");
        // 每个数字
        for(int i = 0; i < digits.length(); i++)
        {
            // 获得字母表
            String letters = keypad[digits.charAt(i) - '0'];
            // 当前队列中元素个数
            int size = queue.size();
            // 队列中每个元素分别和所有字母组合
            for(int k = 0; k < size; k++)
            {
            	String cur = queue.poll();
            	for(int j = 0; j < letters.length(); j++)
                {	
                    queue.offer(cur + letters.charAt(j));
                }
            }
        }
        // 把队列中的元素全部加入result
        result.addAll(queue);
        return result;
    }
}

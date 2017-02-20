public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public String reverseWords(String s) 
	{
        if(s == null || s.length() == 0)
        	return "";
        
        s = s.trim();  // 剪除字符串两端的空格
        String[] words = s.split(" ");  // 以空格分割字符串为单词数组，可能会包含空的词
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--)
        {
        	String word = words[i].trim();  // 剪除单词两端的空格
        	// 单词为空则跳过
        	if(word.length() == 0)
        		continue;
        	if(i != 0)
        		sb.append(word + " ");
        	else
        		sb.append(word);
        }
        return sb.toString();
    }
}

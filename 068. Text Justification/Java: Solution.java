public class Solution {
    // 时间复杂度O(n)，n为单词个数
    // 空间复杂度O(maxWidth)，StringBuilder的长度最大为maxWidth
    public List<String> fullJustify(String[] words, int maxWidth) 
    {
        List<String> result = new ArrayList<String>();  
        if(words == null || words.length == 0)  
            return result;  
        int index = 0;  
        StringBuilder sb = new StringBuilder();  
        while(index < words.length) 
        {  
            // 新的一行，初始化StringBuilder
            sb = new StringBuilder();  
            // 记录这行的字符个数
            int volume = 0;
            // 这行的字符个数且每个单词加一个空格
            int cur_len = 0;
            // 这行的单词个数
            int counter = 0;  
            int initial = index; 
            // 还有单词且这个单词加上本行已经有的长度之和小于等于maxWidth
            while(index < words.length && words[index].length() + cur_len <= maxWidth) 
            {  
            	// 当前行的长度，最后末尾加上一个空格的长度
                cur_len += (words[index].length() + 1);
                // 当前行所有单词的长度，不包括空格
                volume += words[index].length();  
                counter++;  
                index++;  
            }  
            
            // 最后一行，所有单词向左对齐
            if(index == words.length)
            {  
                while(initial < words.length)
                {  
                    sb.append(words[initial++]);  
                    if(sb.length() < maxWidth)  
                    	// 每个单词后加一个空格
                        sb.append(" ");  
                }
                // 还没到规定的长度maxWidth则用空格补齐
                while(sb.length() < maxWidth)
                {
                    sb.append(" ");
                }
                result.add(sb.toString());  
                break;  
            }  
            
            // 本行还需要的空格的个数
            int spaces = maxWidth - volume;
            // 本行单词个数大于1
            if(counter > 1) 
            {  
            	// 计算每个单词后的空格
            	// 两个单词间最少需要的空格数
                int spaces_per_word = spaces / (counter - 1);
                // 如果空格不能被整除，即不能平均分配，记录剩余的额外空格
                int extra_spaces = spaces % (counter - 1);  
                // 不用加等号，因为index现在指向的是下一个单词
                while(initial < index)
                {
                    sb.append(words[initial++]);  
                    // 最后一个单词不需要空格
                    if(--counter == 0)
                        break;  
                    for(int i = 0; i < spaces_per_word; i++)  
                        sb.append(" ");
                    // 如果还有剩余的额外空格
                    if(extra_spaces > 0)
                    {
                        // 每个单词额外加一个空格  
                        sb.append(" ");
                        extra_spaces--;
                    }
                }  
            }  
            // 如果这行只有一个单词，所以空格加到单词后面
            else
            {  
                sb.append(words[initial]);  
                for(int i = 0; i < spaces; i++)  
                    sb.append(" ");  
            }  
            result.add(sb.toString());  
        }  
        return result;      
    }
}

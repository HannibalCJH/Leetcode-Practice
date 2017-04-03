public class Solution {
    public IList<string> FullJustify(string[] words, int maxWidth) 
    {
        IList<string> result = new List<string>();
        if(words == null || words.Length == 0)
            return result;
        
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(index < words.Length)
        {
            sb = new StringBuilder();
            int wordCount = 0, charCount = 0;
            int curLength = 0, start = index;
            while(index < words.Length && curLength + words[index].Length <= maxWidth)
            {
                // 加上单词长度和一个空格
                curLength += words[index].Length + 1;
                // 单词字符个数，没有空格
                charCount += words[index].Length;
                // 单词数加1
                wordCount++;
                // 下一个单词
                index++;
            }
            
            // 最后一行，所有单词向左对齐且单词之间不加额外的空格
            if(index == words.Length)
            {
                for(int i = start; i < words.Length; i++)
                {
                    sb.Append(words[i]);
                    // 每个单词后面加一个空格，最后一个单词视情况而定
                    if(sb.Length < maxWidth)
                        sb.Append(" ");
                }
                // 补齐空格
                while(sb.Length < maxWidth)
                {
                    sb.Append(" ");
                }
                result.Add(sb.ToString());
                break;
            }
            // 这一行需要的空格数
            int spaces = maxWidth - charCount;
            // 这一行单词数大于1
            if(wordCount > 1)
            {
                int spaces_per_word = spaces / (wordCount - 1);
                int extra_spaces = spaces % (wordCount - 1);
                while(wordCount-- > 0)
                {
                    sb.Append(words[start++]);
                    // 最后一个单词后面不加空格
                    if(wordCount == 0)
                        break;
                    for(int i = 0; i < spaces_per_word; i++)
                        sb.Append(" ");
                    if(extra_spaces > 0)
                    {
                        sb.Append(" ");
                        extra_spaces--;
                    }
                }
            }
            else
            {
                sb.Append(words[start]);
                for(int i = 0; i < spaces; i++)
                    sb.Append(" ");
            }
            result.Add(sb.ToString());
        }
        return result;
    }
}

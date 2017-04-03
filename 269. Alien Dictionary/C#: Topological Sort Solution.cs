public class Solution {
    public string AlienOrder(string[] words) 
    {
        Dictionary<char, HashSet<char>> graph = new Dictionary<char, HashSet<char>>();
        for(int i = 0; i < words.Length; i++)
        {
            for(int j = 0; j < words[i].Length; j++)
            {
                char ch = words[i][j];
                // 为了排序结果出现所有字母，对于每个字母，都要初始化
                if(!graph.ContainsKey(ch))
                    graph.Add(ch, new HashSet<char>());
            }
            // 根据连续的两个单词，得到一个相对的字符顺序
            if(i > 0)
                Check(words[i - 1], words[i], graph);
        }
        
        Stack<char> stack = new Stack<char>();
        bool[] visited = new bool[26];
        bool[] isLoop = new bool[26];
        foreach(char ch in graph.Keys)
        {
            if(!DFS(graph, ch, visited, isLoop, stack))
                return "";
        }
        
        StringBuilder sb = new StringBuilder();
        while(stack.Count > 0)
        {
            sb.Append(stack.Pop());
        }
        return sb.ToString();
    }
    
    private bool DFS(Dictionary<char, HashSet<char>> graph, char ch, bool[] visited, bool[] isLoop, Stack<char> stack)
    {
        int i = ch - 'a';
        if(visited[i])
            return true;
        if(isLoop[i])
            return false;
            
        isLoop[i] = true;
        foreach(char next in graph[ch])
        {
            if(!DFS(graph, next, visited, isLoop, stack))
                return false;
        }
        
        visited[i] = true;
        stack.Push(ch);
        return true;
    }
    
    private void Check(string word1, string word2, Dictionary<char, HashSet<char>> graph)
    {
        int i = 0;
        // 找到两者第一个不相等的字符
        while(i < word1.Length && i < word2.Length && word1[i] == word2[i])
        {
            i++;
        }
        if(i < word1.Length && i < word2.Length)
        {
            graph[word1[i]].Add(word2[i]);
        }
    }
}

public class Solution {
    // 拓扑排序
    // 时间复杂度O(nk + m^m)，其中n为单词个数，k为平均单词长度，m为总共给出的字母个数
    // 空间复杂度O(m^m)
    public String alienOrder(String[] words) 
	{
        Map<Character, Set<Character>> graph = new HashMap<Character, Set<Character>>();
        for(int i = 0; i < words.length; i++) 
        {
            for(int j = 0; j < words[i].length(); j++) 
            {
                char ch = words[i].charAt(j);
                // 为了排序结果出现所有字母，对于每个字母，都要初始化，
                if(!graph.containsKey(ch))                  
                    graph.put(ch, new HashSet<Character>());
            }
            
            // 根据连续的两个单词，得到一个相对的字符顺序
            if(i > 0)
                check(words[i - 1], words[i], graph);
        }
        
        Stack<Character> stack = new Stack<Character>();
        // 标记DFS路径上的点，避免重复计算
        boolean[] visited = new boolean[26];
        // 用来发现环
        boolean[] isLoop = new boolean[26];
        for(char ch : graph.keySet())
        {
            // 有环，无效输入，返回空字符串
            if(!dfs(graph, ch, visited, isLoop, stack)) 
                return "";
        }
        StringBuilder sb = new StringBuilder();
        
        // 得到最终正确的字母顺序
        while(!stack.isEmpty()) 
            sb.append(stack.pop());
        return sb.toString();
    }
    
    private boolean dfs(Map<Character, Set<Character>> graph, char ch, boolean[] visited, boolean[] isLoop, Stack<Character> stack) 
    {
        int i = ch - 'a';
        // 已经搜过了，可以直接跳过
        if(visited[i])
        	return true;
        // 发现环，说明输入的词典是有问题的
        if(isLoop[i]) 
        	return false;
        // 往下搜索之前把isLoop[i]标记为已经走过，在之后的递归中如果再碰到这个字母就形成了环
        isLoop[i] = true;
        for(char next : graph.get(ch))
            if(!dfs(graph, next, visited, isLoop, stack)) 
                return false;
        // 搜索完毕后，说明从当前字母往下的所有路径中没有形成环，设visited[i]为真，这样可以减少后面的计算
        visited[i] = true;
        stack.push(ch);
        return true;
    }
    
    public void check(String word1, String word2, Map<Character, Set<Character>> map) 
    {
        int i = 0;
        // 找到两者第一个不相等的字符
        while(i < word1.length() && i < word2.length() && word1.charAt(i) == word2.charAt(i))
        {
            i++;
        }
        if(i < word1.length() && i < word2.length())
        {
        	// 对于第一个不相等的字符，前一个单词的字符排在后一个单词的字符的前面
        	// 这里相当于加一条有向线段从word1(i)到word2(i)
            map.get(word1.charAt(i)).add(word2.charAt(i));
        }
    }
}

public class Solution {
    // 时间复杂度O(n^2+n*(26^k))，n为词典单词数，k为单词的长度，每个位置都有26种变换所以为O(26^k)，如果运气不好
    // 时间复杂度O(n)
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) 
    {
        // 把单词加入哈希集合，利于快速查找
        HashSet<String> dict = new HashSet<>();
        for(String word : wordList)
        {
            dict.add(word);
        }
        
        List<List<String>> result = new ArrayList<>();
        // 单词的邻接列表，列表中为词典中存在的从当前单词变换一个字母能够形成的单词
        HashMap<String, List<String>> map = new HashMap<>();
        // 记录一个单词从起始单词变换过来需要的步数，可以看成BFS中节点的层数
        HashMap<String, Integer> distance = new HashMap<>();
        
        // BFS，建立单词有向图，用邻接列表保存各个单词能变换一个字母到达的词典中的单词
        // 同时记录下每个单词从起始节点变化过来所需的步数
        bfs(beginWord, endWord, dict, map, distance);
        List<String> path = new ArrayList<>();
        // DFS，对BFS建立的单词有向图进行搜索，寻找可行路径
        dfs(result, path, endWord, beginWord, distance, map);
        return result;
    }
    
    // 从目标单词逆向搜索
    private void dfs(List<List<String>> result, List<String> path, String cur, String beginWord, HashMap<String, Integer> distance, HashMap<String, List<String>> map)
    {
        // 加入当前单词
        path.add(cur);
        // 当前单词是起始单词则找到了一条路径
        if(cur.equals(beginWord))
        {
            // 路径是逆向的所以先要反转
            Collections.reverse(path);
            result.add(new ArrayList<String>(path));
            // 反转回来，因为我们后面还要回溯
            Collections.reverse(path);
        }
        // 注意要判断当前单词是否在map中存在，这里有可能目标单词在词典中不存在，所以没有可循路径
        else if(map.containsKey(cur))
        {
            // 遍历当前单词的上一层单词
            for(String next : map.get(cur))
            {
                // 这个单词被访问过且是当前单词的上一层单词，这样可以保证路径最短
                if(distance.containsKey(next) && distance.get(next) + 1 == distance.get(cur))
                {
                    dfs(result, path, next, beginWord, distance, map);
                }
            }
        }
        // 回溯
        path.remove(path.size() - 1);
    }
    
    private void bfs(String beginWord, String endWord, HashSet<String> dict, HashMap<String, List<String>> map, HashMap<String, Integer> distance)
    {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        // 起始单词层数为0即步长为0
        distance.put(beginWord, 0);
        // 初始化词典中所有单词的邻接列表
        for(String word : dict)
        {
            map.put(word, new ArrayList<String>());
        }
        
        while(!queue.isEmpty())
        {
            String word = queue.poll();
            // 下一层，步长加1
            int length = distance.get(word) + 1;
            for(String nextWord : getNextWords(word, dict))
            {
                // 把当前单词加入到下个单词的邻接列表中
                map.get(nextWord).add(word);
                // 这个单词没有被访问过
                // 如果被访问过，一方面说明可能我们往回走了，也有可能是这个单词可以以更少的步数（在之前的层中）从起始节点变化得到
                // 我们没有必要绕远了到现在的层数再访问这个节点，这样我们保证在建立的图中，起点到终点的路径是最短的
                if(!distance.containsKey(nextWord))
                {
                    distance.put(nextWord, length);
                    queue.offer(nextWord);
                }
            }
        }
    }
    
    private List<String> getNextWords(String word, HashSet<String> dict)
    {
        List<String> nextWords = new ArrayList<>();
        for(int i = 0; i < word.length(); i++)
        {
            for(char j = 'a'; j <= 'z'; j++)
            {
                if(j == word.charAt(i))
                    continue;
                    
                StringBuilder nextWord = new StringBuilder(word);
                nextWord.setCharAt(i, j);
                if(dict.contains(nextWord.toString()))
                    nextWords.add(nextWord.toString());
            }
        }
        return nextWords;
    }
}

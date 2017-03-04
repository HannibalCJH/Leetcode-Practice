public class Solution {
    // BFS
    // 时间复杂度O(n*(26^k))，n为词典单词数，k为单词的长度，每个位置都有26种变换所以为O(26^k)，如果运气不好，
    // 所有的变化词典中都有那每次有n个下一步单词要走
    // 空间复杂度O(n*(26^k))
    public int ladderLength(String beginWord, String endWord, List<String> wordList) 
    {
        // 当初始单词和目标单词一样时
        if(beginWord.equals(endWord))
            return 1;
        
        // 把单词加入哈希集合，利于快速查找
        HashSet<String> dict = new HashSet<String>();
        for(String word : wordList)
        {
            dict.add(word);
        }
        
        int length = 1;
        // 用来做BFS
        Queue<String> queue = new LinkedList<String>();
        // 保存之前走过的单词，以防往回走
        HashSet<String> set = new HashSet<String>();
        queue.offer(beginWord);
        set.add(beginWord);
        // BFS，从初始单词作为根节点，每次遍历当前单词改变一个字母的单词
        while(!queue.isEmpty())
        {
            length++;
            int size = queue.size();
            // 类似二叉树逐层扫描，对上一层的每个单词进行一个字母的变换
            for(int i = 0; i < size; i++)
            {
                String word = queue.poll();
                
                for(String nextWord : getNextWords(word, dict))
                {
                    // 这个条件是判断nextWord是否已经在转变的序列中
                	// 比如从log->lot->got->get，当前word是got，它的nextWords集合里
                	// 既有向后变化的get也有之前的单词lot，这里是为了以防我们从got变回lot
                    if(!set.contains(nextWord))
                    {
                        // 变换后的单词就是目标单词，返回走过的步长
                        if(nextWord.equals(endWord))
                            return length;
                        // 把这个变换后的单词加入队列的哈希集合，用来下一层遍历
                        queue.offer(nextWord);
                        set.add(nextWord);
                    }
                }
            }
        }
        // 没有找到可行的路径
        return 0;
    }
    
    // 搜索word改变一个字母以后的单词
    private List<String> getNextWords(String word, HashSet<String> dict)
    {
        List<String> nextWords = new ArrayList<String>();
        // 对原来的单词的每个位置进行替换
        for(int i = 0; i < word.length(); i++)
        {
            // 用26个小写字母一个个进行替换
            for(char j = 'a'; j <= 'z'; j++)
            {
                // 跳过这个位置原来的字母
                if(j == word.charAt(i))
                    continue;
                StringBuilder nextWord = new StringBuilder(word);
                // 替换字母
                nextWord.setCharAt(i, j);
                // 如果这个新的单词在词典中存在就加入nextWords
                if(dict.contains(nextWord.toString()))
                    nextWords.add(nextWord.toString());
            }
        }
        return nextWords;
    }
}

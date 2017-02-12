// Trie节点
class TrieNode
{
    TrieNode[] links;
    boolean isEnd;
    
    TrieNode()
    {
        this.links = new TrieNode[26];
        this.isEnd = false;
    }
    
    public boolean containsKey(char ch)
    {
        return links[ch - 'a'] != null;
    }
    
    public void put(char ch, TrieNode node)
    {
        links[ch - 'a'] = node;
    }
    
    public TrieNode get(char ch)
    {
        return links[ch - 'a'];
    }
    
    public void setEnd()
    {
        this.isEnd = true;
    }
    
    public boolean isEnd()
    {
        return this.isEnd;
    }
}


public class Trie {
    public TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() 
    {
        root = new TrieNode();
    }
    
    // 时间复杂度O(n)，n为单词的长度
    // 空间复杂度O(n)，最坏的情况是单词中所有的字母都要创建一个TrieNode
    /** Inserts a word into the trie. */
    public void insert(String word) 
    {
        // 初始化为根节点
        TrieNode node = root;
        // 类似DFS一个个字符深入
        // 1. 字母存在则取得这个字母的TrieNode继续往下链接
        // 2. 字母不存在则新建以这个字母为index的TrieNode，同样获取这个TrieNode继续往下链接
        for(int i = 0; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            // 不存在这个TrieNode就新开一个
            if(!node.containsKey(ch))
                node.put(ch, new TrieNode());
            // 获得这个字母对应的TrieNode，继续往下深入
            node = node.get(ch);
        }
        // 单词遍历完，给最后一个字母标识成是一个单词的结尾
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) 
    {
        TrieNode end = searchPrefix(word);
        return end != null && end.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) 
    {
        return searchPrefix(prefix) == null ? false : true;
    }
    
    // 时间复杂度O(n)，n为单词长度
    // 空间复杂度O(1)
    // 寻找是否存在prefix且返回最后一个字母的TrieNode
    private TrieNode searchPrefix(String prefix)
    {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++)
        {
            char ch = prefix.charAt(i);
            if(!node.containsKey(ch))
                return null;
            node = node.get(ch);
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

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
    
    public TrieNode[] nextNodes()
    {
        return this.links;
    }
}

// Trie树
class Trie 
{
    public TrieNode root;

    public Trie() 
    {
        root = new TrieNode();
    }
    
    // 时间复杂度O(n)，n为单词的长度
    // 空间复杂度O(n)，最坏的情况是单词中所有的字母都要创建一个TrieNode
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
    
    public boolean search(String word) 
    {
        return dfs(root, word);
    }
    
    // 递归检查
    // 1. 对于没有通配符的情况下，搜索只是一条路径，直接for循环就行，比如Leetcode 208题
    // 2. 当有通配符时，就是树的搜索，所有可能的路径都要遍历，所以采用递归
    // 时间复杂度最坏是O(26^n)，n为字符串长度。这只有在所有字符都是通配符的情况下。
    // 空间复杂度O(n)
    private boolean dfs(TrieNode node, String word) 
    {
        // 1. 第一个字符不是通配符且当前节点的链接中没有这个字符
        // 2. 已经遍历完了单词但是当前的节点也就是最后一个字符并不是一个词的结尾
        if((!word.isEmpty() && word.charAt(0) != '.' && !node.containsKey(word.charAt(0))) || (word.isEmpty() && !node.isEnd()))
            return false;
        // 已经遍历完了单词且当前字符是一个词的结尾
        if(word.isEmpty() && node.isEnd())
            return true;
        boolean result = false;
        char ch = word.charAt(0);
        // 第一个字符是通配符
        if(ch == '.')
        {
            // 对所有当前节点的下一个链接进行搜索，只要有一个成功匹配即可
            // 这里要遍历每一条可能的路径
            for(TrieNode next : node.nextNodes())
                if (next != null) 
                    result = result || dfs(next, word.substring(1));
        }
        else 
            // 普通的字符，单路径继续往下搜索
            result = dfs(node.get(ch), word.substring(1));
        return result;
    }
}

public class WordDictionary {
    Trie trieTree;
    /** Initialize your data structure here. */
    public WordDictionary() 
    {
        trieTree = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) 
    {
        trieTree.insert(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) 
    {
        return trieTree.search(word);    
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

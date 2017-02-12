public class TrieNode
{
    TrieNode[] links;
    bool isEnd;
    
    public TrieNode()
    {
        this.links = new TrieNode[26];
        this.isEnd = false;
    }
    
    public bool ContainsKey(char ch)
    {
        return links[ch - 'a'] != null;
    }
    
    public void Add(char ch, TrieNode node)
    {
        links[ch - 'a'] = node;
    }
    
    public TrieNode Get(char ch)
    {
        return links[ch - 'a'];
    }
    
    public void SetEnd()
    {
        this.isEnd = true;
    }
    
    public bool IsEnd()
    {
        return this.isEnd;
    }
}

public class Trie {
    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() 
    {
        root = new TrieNode();    
    }
    
    /** Inserts a word into the trie. */
    public void Insert(string word) 
    {
        TrieNode node = root;
        for(int i = 0; i < word.Length; i++)
        {
            char ch = word[i];
            if(!node.ContainsKey(ch))
                node.Add(ch, new TrieNode());
            node = node.Get(ch);
        }
        node.SetEnd();
    }
    
    /** Returns if the word is in the trie. */
    public bool Search(string word) 
    {
        TrieNode end = SearchPrefix(word);
        return end != null && end.IsEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public bool StartsWith(string prefix) 
    {
        return SearchPrefix(prefix) != null;
    }
    
    public TrieNode SearchPrefix(string prefix)
    {
        TrieNode node = root;
        for(int i = 0; i < prefix.Length; i++)
        {
            if(!node.ContainsKey(prefix[i]))
                return null;
            node = node.Get(prefix[i]);
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.Insert(word);
 * bool param_2 = obj.Search(word);
 * bool param_3 = obj.StartsWith(prefix);
 */

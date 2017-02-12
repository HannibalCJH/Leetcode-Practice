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
    
    public TrieNode[] NextNodes()
    {
        return this.links;
    }
}

class Trie {
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
        return DFS(root, word);
    }
    
    private bool DFS(TrieNode node, string word)
    {
        if((word.Length != 0 && word[0] != '.' && !node.ContainsKey(word[0])) || (word.Length == 0 && !node.IsEnd()))
            return false;
        if(word.Length == 0 && node.IsEnd())
            return true;
        char ch = word[0];
        bool result = false;
        if(ch == '.')
        {
            foreach(TrieNode next in node.NextNodes())
                if(next != null)
                    result = result || DFS(next, word.Substring(1));
        }
        else
            result = DFS(node.Get(ch), word.Substring(1));
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
    public void AddWord(string word) 
    {
        trieTree.Insert(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public bool Search(string word) 
    {
        return trieTree.Search(word);    
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.AddWord(word);
 * bool param_2 = obj.Search(word);
 */

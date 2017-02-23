class TrieNode
{
    public TrieNode[] links;
    public String word;
    public TrieNode()
    {
        links = new TrieNode[26];
        word = null;
    }
}

public class Solution {
    public IList<string> FindWords(char[,] board, string[] words) 
    {
        if(board == null || board.GetLength(0) == 0 || board.GetLength(1) == 0)
            return new List<string>();
        
        int m = board.GetLength(0), n = board.GetLength(1);
        IList<string> result = new List<string>();
        TrieNode root = BuildTrie(words);
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                DFS(result, board, i, j, root);
            }
        }
        return result;
    }
    
    private void DFS(IList<string> result, char[,] board, int x, int y, TrieNode node)
    {
        if(x < 0 || y < 0 || x >= board.GetLength(0) || y >= board.GetLength(1) 
            || board[x, y] == '#' || node.links[board[x, y] - 'a'] == null)
            return;
            
        char ch = board[x, y];
        node = node.links[ch - 'a'];
        if(node.word != null)
        {
            result.Add(node.word);
            node.word = null;
        }
        
        board[x, y] = '#';
        DFS(result, board, x - 1, y, node);
        DFS(result, board, x + 1, y, node);
        DFS(result, board, x, y - 1, node);
        DFS(result, board, x, y + 1, node);
        board[x, y] = ch;
    }
    
    private TrieNode BuildTrie(string[] words)
    {
        TrieNode root = new TrieNode();
        foreach(string word in words)
        {
            TrieNode node = root;
            for(int i = 0; i < word.Length; i++)
            {
                char ch = word[i];
                if(node.links[ch - 'a'] == null)
                    node.links[ch - 'a'] = new TrieNode();
                node = node.links[ch - 'a'];
            }
            node.word = word;
        }
        return root;
    }
}

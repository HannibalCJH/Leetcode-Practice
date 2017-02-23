class TrieNode
{
    TrieNode[] links;
    String word;
    public TrieNode()
    {
        links = new TrieNode[26];
        word = null;
    }
}

public class Solution {
    // 时间复杂度O(kl+mn*(4^k))，k为单词平均长度，l为单词个数
    // 空间复杂度O(k)，k为单词平均长度
    public List<String> findWords(char[][] board, String[] words) 
    {
        if(board == null || board.length == 0 || board[0].length == 0)
            return new ArrayList<String>();
            
        int m = board.length, n = board[0].length;
        List<String> result = new ArrayList<String>();
        // 建立Trie树
        TrieNode root = buildTrie(words);
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                dfs(result, board, i, j, root);
            }
        }
        return result;
    }
    
    private void dfs(List<String> result, char[][]board, int x, int y, TrieNode node)
    {
        // 超过边界或者这个格子已经访问过或者Trie节点的后面的节点没有这个字母
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == '#' || node.links[board[x][y] - 'a'] == null)
            return;
        char ch = board[x][y];
        // 取得字母对应的Trie节点
        node = node.links[ch - 'a'];
        // 这个字母是一个单词的末尾
        if(node.word != null)
        {
            // 把这个单词加入到结果列表中
            result.add(node.word);
            // 删除这个单词的末尾标识，我们要避免在结果集中加入重复的单词
            node.word = null;
        }
        
        // 设置这个格子已经访问过
        board[x][y] = '#';
        // 往四个方向递归搜索
        dfs(result, board, x - 1, y, node);
        dfs(result, board, x + 1, y, node);
        dfs(result, board, x, y - 1, node);
        dfs(result, board, x, y + 1, node);
        // 回溯
        board[x][y] = ch;
    }
    
    private TrieNode buildTrie(String[] words)
    {
        TrieNode root = new TrieNode();
        // 遍历每个单词，简历Trie树
        for(String word : words)
        {
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++)
            {
                char ch = word.charAt(i);
                if(node.links[ch - 'a'] == null)
                    node.links[ch - 'a'] = new TrieNode();
                node = node.links[ch - 'a'];
            }
            // 把这个单词存在叶节点
            node.word = word;
        }
        return root;
    }
}

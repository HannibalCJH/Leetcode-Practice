public class Solution {
    // 时间复杂度O(mn(4^k))，k为单词长度
    // 在exist函数中遍历每个格子为O(mn)，每次递归搜索是个方向，最多搜索单词长度的次数为O(4^k)，所以最后是O(mn(4^k))
    // 空间复杂度O(mn)，栈空间是O(k)，k为单词长度。但是当mn小于k时这个单词不可能再board中，因为board中就算所有的字母加起来都不够长
    public boolean exist(char[][] board, String word) 
    {
        if(board == null || board.length == 0 || board[0].length == 0)
            return false;
        
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                // 当首字母和这个格子的字母相同才进行递归搜索
                if(board[i][j] == word.charAt(0) && findWord(board, word, 0, i, j, visited))
                    return true;
        return false;
    }
    
    private boolean findWord(char[][] board, String word, int index, int x, int y, boolean[][] visited)
    {
        // 单词遍历完毕，所有字母都符合
        if(index == word.length())
            return true;
        // 不符合的情况
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y] || board[x][y] != word.charAt(index))
            return false;
        // 设这个格子为访问过
        visited[x][y] = true;
        // 递归搜索
        boolean result = findWord(board, word, index + 1, x - 1, y, visited)
                      || findWord(board, word, index + 1, x + 1, y, visited)
                      || findWord(board, word, index + 1, x, y - 1, visited)
                      || findWord(board, word, index + 1, x, y + 1, visited);
        // 回溯
        visited[x][y] = false;
        return result;
    }
}

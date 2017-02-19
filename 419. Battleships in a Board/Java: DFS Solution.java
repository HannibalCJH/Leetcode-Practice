public class Solution {
    // 同Number of Islands一样的解法
    // 时间复杂度O(mn)，空间复杂度O(max(m, n))看递归栈的空间
    public int countBattleships(char[][] board) 
    {
        if(board == null || board.length == 0 || board[0].length == 0)
            return 0;
        
        int count = 0;
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
            {
                if(board[i][j] == 'X')
                {
                    dfs(board, i, j);
                    count++;
                }
            }
        return count;
    }
    
    private void dfs(char[][] board, int x, int y)
    {
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == '.')
            return;
        
        board[x][y] = '.';
        
        dfs(board, x - 1, y);
        dfs(board, x + 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}

public class Solution {
    // 时间复杂度O(mn)，空间复杂度O(1)
    public int countBattleships(char[][] board) 
    {
        if(board == null || board.length == 0 || board[0].length == 0)
            return 0;
        
        int count = 0;
        int m = board.length, n = board[0].length;
        // 用船的左上角来表示一艘船，这样的条件就是'X'的左边和上方都没有相邻的'X'
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i][j] == '.')
                    continue;
                // 左边没有'X'
                if(i > 0 && board[i - 1][j] == 'X')
                    continue;
                // 上方没有'X'
                if(j > 0 && board[i][j - 1] == 'X')
                    continue;
                count++;
            }
        }
        return count;
    }
}

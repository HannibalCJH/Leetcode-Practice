public class Solution {
    public void GameOfLife(int[,] board) 
    {
        if(board == null || board.GetLength(0) == 0 || board.GetLength(1) == 0)
            return;
        
        int m = board.GetLength(0), n = board.GetLength(1);
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                int lives = GetLiveNum(board, i, j);
                
                // 01 --> 11
                if(board[i, j] == 1 && (lives == 2 || lives == 3))
                    board[i, j] = 3;
                // 00 --> 10
                if(board[i, j] == 0 && lives == 3)
                    board[i, j] = 2;
            }
        }
        
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                board[i, j] >>= 1;
    }
    
    private int GetLiveNum(int[,] board, int x, int y)
    {
        int count = 0;
        for(int i = x - 1; i <= x + 1; i++)
        {
            for(int j = y - 1; j <= y + 1; j++)
            {
                if(i < 0 || j < 0 || i >= board.GetLength(0) || j >= board.GetLength(1) || (i == x && j == y))
                    continue;
                count += board[i, j] & 1;
            }
        }
        return count;
    }
}

public class Solution {
    public int CountBattleships(char[,] board) 
    {
        if(board == null || board.GetLength(0) == 0 || board.GetLength(1) == 0)
            return 0;
        
        int count = 0;
        int m = board.GetLength(0), n = board.GetLength(1);
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(board[i, j] == '.')
                    continue;
                if(i > 0 && board[i - 1, j] == 'X')
                    continue;
                if(j > 0 && board[i, j - 1] == 'X')
                    continue;
                count++;
            }
        }
        return count;
    }
}

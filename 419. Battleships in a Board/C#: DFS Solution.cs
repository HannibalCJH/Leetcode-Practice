public class Solution {
    public int CountBattleships(char[,] board) 
    {
        if(board == null || board.GetLength(0) == 0 || board.GetLength(1) == 0)
            return 0;
        int count = 0;
        
        for(int i = 0; i < board.GetLength(0); i++)
            for(int j = 0; j < board.GetLength(1); j++)
            {
                if(board[i, j] == 'X')
                {
                    DFS(board, i, j);
                    count++;
                }
            }
            
        return count;
    }
    
    private void DFS(char[,] board, int x, int y)
    {
        if(x < 0 || y < 0 || x >= board.GetLength(0) || y >= board.GetLength(1) || board[x, y] == '.')
            return;
            
        board[x, y] = '.';
        DFS(board, x - 1, y);
        DFS(board, x + 1, y);
        DFS(board, x, y + 1);
        DFS(board, x, y - 1);
    }
}

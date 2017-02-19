public class TicTacToe {
    int[,] rows;
    int[,] cols;
    int[] diag;
    int[] anti_diag;
    int n;

    // 时间复杂度O(1)，空间复杂度O(n)
    /** Initialize your data structure here. */
    public TicTacToe(int n) 
    {
        rows = new int[2, n];
        cols = new int[2, n];
        diag = new int[2];
        anti_diag = new int[2];
        this.n = n;
    }
    
    // 时间复杂度O(n^2)，空间复杂度O(n)
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int Move(int row, int col, int player) 
    {
        player--;
        rows[player, row]++;
        cols[player, col]++;
        if(row == col)
            diag[player]++;
        if(row == n - 1 - col)
            anti_diag[player]++;
        
        for(int i = 0; i < 2; i++)
        {
            if(diag[i] == n || anti_diag[i] == n)
                return i + 1;
            
            for(int j = 0; j < n; j++)
            {
                if(rows[i, j] == n)
                    return i + 1;
                if(cols[i, j] == n)
                    return i + 1;
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.Move(row,col,player);
 */

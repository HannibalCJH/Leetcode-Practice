public class TicTacToe {
    int[,] rows;
    int[,] cols;
    int[] diag;
    int[] anti_diag;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) 
    {
        rows = new int[2, n];
        cols = new int[2, n];
        diag = new int[2];
        anti_diag = new int[2];
        this.n = n;
    }
    
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
        
        if(rows[player, row] == n || cols[player, col] == n)
            return player + 1;
        if(diag[player] == n || anti_diag[player] == n)
            return player + 1;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.Move(row,col,player);
 */

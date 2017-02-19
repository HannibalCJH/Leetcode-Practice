public class TicTacToe {
    int[] rows;
    int[] cols;
    int diag;
    int anti_diag;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) 
    {
        rows = new int[n];
        cols = new int[n];
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
        int toAdd = player == 1 ? 1 : -1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        if(row == col)
            diag += toAdd;
        if(row == n - 1 - col)
            anti_diag += toAdd;
            
        if(Math.Abs(rows[row]) == n || Math.Abs(cols[col]) == n || Math.Abs(diag) == n || Math.Abs(anti_diag) == n)
        {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.Move(row,col,player);
 */

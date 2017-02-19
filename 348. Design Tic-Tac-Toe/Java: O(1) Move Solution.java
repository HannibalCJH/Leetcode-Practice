public class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diag;
    private int anti_diag;
    private int n;
    
    // 时间复杂度O(1)，空间复杂度O(n)
    /** Initialize your data structure here. */
    public TicTacToe(int n) 
    {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
    }
    
    // 时间复杂度O(1)，空间复杂度O(n)
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) 
    {
        
        int toAdd = player == 1 ? 1 : -1;
        // 玩家1每次加1，玩家2每次减1
        rows[row] += toAdd;
        cols[col] += toAdd;
        // 棋子在对角线上
        if(row == col)
            diag += toAdd;
        if(row == n - 1 - col)
            anti_diag += toAdd;
        // 如果行、列或者对角线中的绝对值为n则说明这行或这列中只有某个玩家的棋子
        if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n  || Math.abs(anti_diag) == n)
        {
            return player;
        }
        
        return 0;    
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

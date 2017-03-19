public class TicTacToe {
    // 记录当前棋盘中每个玩家棋子的状况
    int[][] rows;
    int[][] cols;
    int[] diag;
    int[] anti_diag;
    int n;
    
    // 时间复杂度O(1)，空间复杂度O(n)，棋盘行和列的数目都为n
    /** Initialize your data structure here. */
    public TicTacToe(int n) 
    {
        rows = new int[2][n];
        cols = new int[2][n];
        diag = new int[2];
        anti_diag = new int[2];
        this.n = n;
    }
    
    // 时间复杂度O(1)，空间复杂度O(n)，棋盘行和列的数目都为n
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
        // 数组从0开始，使玩家号和下标对应
        player--;
        // 下棋，对应行和列上的棋子个数加1
        rows[player][row]++;
        cols[player][col]++;
        // 棋子在对角线上
        if(row == col)
            diag[player]++;
        if(row == n - 1 - col)
            anti_diag[player]++;
        
        // 下完这一步棋以后检查这个玩家是不是已经达到了胜利条件
        // 在这颗棋子落下后，所在的行或列中该名玩家的棋子是否达到n
        if(rows[player][row] == n || cols[player][col] == n)
            return player + 1;
        // 所在的对角线上该名玩家的棋子是否达到n
        if(diag[player] == n || anti_diag[player] == n)
            return player + 1;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

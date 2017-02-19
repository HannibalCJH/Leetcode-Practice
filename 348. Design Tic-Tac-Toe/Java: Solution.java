public class TicTacToe {
    // 记录每个玩家在每一行和每一列放的棋子的个数
	int[][] rows = new int[2][];
    int[][] cols = new int[2][];
    int[] diag = new int[2];
    int[] anti_diag = new int[2];
    int n;


    // 时间复杂度O(n)，空间复杂度O(n)，棋盘行和列的数目都为n
    /** Initialize your data structure here. */
    public TicTacToe(int n) 
    {
        for(int i = 0; i < n; i++) 
        {
            rows[0] = new int[n];
            rows[1] = new int[n];
            cols[0] = new int[n];
            cols[1] = new int[n];
        }
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
    public int move(int row, int col, int player) 
    {
        player--; // 数组从0开始，使玩家号和下标对应
        // 对应行和列上的棋子个数加1
        rows[player][row]++;
        cols[player][col]++;
        // 棋子在对角线上
        if(row == col) 
        	diag[player]++;
        if(row + col == n - 1) 
        	anti_diag[player]++;
        // 检查是否已经有行、列或者对角线被某一个玩家占满
        for(int i = 0; i < 2; i++) 
        {
        	// 检查对角线
            if(diag[i] == n || anti_diag[i] == n) 
            	return i + 1;
            // 检查各行各列
            for(int j = 0; j < n; j++) 
            {
                if(rows[i][j] == n) 
                	return i + 1;
                if(cols[i][j] == n) 
                	return i + 1;
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */

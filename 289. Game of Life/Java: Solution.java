public class Solution {
    // 时间复杂度O(mn)，空间复杂度O(1)
    public void gameOfLife(int[][] board) 
	{
        if(board == null || board.length == 0 || board[0].length == 0) 
        	return;
        
        int m = board.length, n = board[0].length;
        
        // 对每个元素进行状态标记
        // [2nd bit, 1st bit] = [next state, current state]
        // 00  dead (next) <- dead (current)
        // 01  dead (next) <- live (current)  
        // 10  live (next) <- dead (current)  
        // 11  live (next) <- live (current) 
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++) 
            {
                // 注意下一次的状态位默认为0
                // 计算邻居的活元素个数
                int lives = getLiveNum(board, i, j);
                // 当前元素为活元素且邻居的活元素个数为2或3，这个元素在下次更新时仍然是活元素
                // 二进制表示01 --> 11
                if(board[i][j] == 1 && (lives == 2 || lives == 3))
                    board[i][j] = 3;
                // 当前元素为死元素且邻居的活元素个数为3，这个元素在下次更新时变为活元素
                // 二进制表示00 --> 10
                if(board[i][j] == 0 && lives == 3)
                    board[i][j] = 2;
            }
        }
        // 根据状态标记对每个元素进行更新
        for(int i = 0; i < m; i++) 
            for(int j = 0; j < n; j++)
                board[i][j] >>= 1; 
    }
    
    private int getLiveNum(int[][] board, int x, int y) 
    {
        int count = 0;
        for(int i = x - 1; i <= x + 1; i++) 
        {
            for(int j = y - 1; j <= y + 1; j++) 
            {
            	// 超过边界算死元素并且不算该元素本身
                if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || (i == x && j == y)) 
                	continue;
                count += board[i][j] & 1;
            }
        }
        return count;
    }
}

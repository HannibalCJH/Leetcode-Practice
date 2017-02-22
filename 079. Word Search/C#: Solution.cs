public class Solution {
    public bool Exist(char[,] board, string word) 
    {
        if(board == null || board.GetLength(0) == 0 || board.GetLength(1) == 0)
            return false;
        
        int m = board.GetLength(0), n = board.GetLength(1);
        bool[,] visited = new bool[m, n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(board[i, j] == word[0] && FindWord(board, word, 0, i, j, visited))
                    return true;
        return false;
    }
    
    private bool FindWord(char[,] board, string word, int index, int x, int y, bool[,] visited)
    {
        if(index == word.Length)
            return true;
        
        if(x < 0 || y < 0 || x >= board.GetLength(0) || y >= board.GetLength(1) || visited[x, y] || board[x, y] != word[index])
            return false;
            
        visited[x, y] = true;
        bool result = FindWord(board, word, index + 1, x - 1, y, visited)
                   || FindWord(board, word, index + 1, x + 1, y, visited)
                   || FindWord(board, word, index + 1, x, y - 1, visited)
                   || FindWord(board, word, index + 1, x, y + 1, visited);
                  
        visited[x, y] = false;
        return result;
    }
}

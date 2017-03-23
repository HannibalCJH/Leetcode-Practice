public class Solution {
    public void WallsAndGates(int[,] rooms) 
    {
        for(int i = 0; i < rooms.GetLength(0); i++)
        {
            for(int j = 0; j < rooms.GetLength(1); j++)
            {
                if(rooms[i, j] == 0)
                    DFS(rooms, i, j, 0);
            }
        }
    }
    
    private void DFS(int[,] rooms, int x, int y, int distance)
    {
        if(x < 0 || y < 0 || x >= rooms.GetLength(0) || y >= rooms.GetLength(1) || rooms[x, y] < distance)
            return;
        
        rooms[x, y] = distance;
        DFS(rooms, x - 1, y, distance + 1);
        DFS(rooms, x + 1, y, distance + 1);
        DFS(rooms, x, y - 1, distance + 1);
        DFS(rooms, x, y + 1, distance + 1);
    }
}

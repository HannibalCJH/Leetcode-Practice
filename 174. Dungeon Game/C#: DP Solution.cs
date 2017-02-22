public class Solution {
    public int CalculateMinimumHP(int[,] dungeon) 
    {
        int m = dungeon.GetLength(0), n = dungeon.GetLength(1);
        int[,] minHP = new int[m, n];
        
        // 最后一格
        minHP[m - 1, n - 1] = Math.Max(1 - dungeon[m - 1, n - 1], 1);
        // 最后一列
        for(int i = m - 2; i >= 0; i--)
            minHP[i, n - 1] = Math.Max(minHP[i + 1, n - 1] - dungeon[i, n - 1], 1);
        // 最后一行
        for(int i = n - 2; i >= 0; i--)
            minHP[m - 1, i] = Math.Max(minHP[m - 1, i + 1] - dungeon[m - 1, i], 1);
        // 其他格子
        for(int i = m - 2; i >= 0; i--)
        {
            for(int j = n - 2; j >= 0; j--)
            {
                minHP[i, j] = Math.Max(Math.Min(minHP[i + 1, j], minHP[i, j + 1]) - dungeon[i, j], 1);
            }
        }
        return minHP[0, 0];
    }
}

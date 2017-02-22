public class Solution {
    // 动态规划，从终点往起点逆推
    // 时间复杂度O(mn)，空间复杂度O(mn)
    public int calculateMinimumHP(int[][] dungeon) 
    {
        int m = dungeon.length, n = dungeon[0].length;
        // minHP[i][j]表示到了i，j这个点后者保证存活的情况下能到达终点的最少血量
        int[][] minHP = new int[m][n];
        // 右下角最后一格的血量，如果dungeon是正数即回复生命值，那我们只要保证走到这一格还有1的血量即可
        // 如果是负数我们起码要保证有1 + |dungeon|即1 - dungeon的血量
        minHP[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
        // 最后一列只能从下方逆推，需要预先处理
        for(int i = m - 2; i >= 0; i--)
            minHP[i][n - 1] = Math.max(minHP[i + 1][n - 1] - dungeon[i][n - 1], 1);
        // 最后一行只能从右边逆推，需要预先处理
        for(int i = n - 2; i >= 0; i--)
            minHP[m - 1][i] = Math.max(minHP[m - 1][i + 1] - dungeon[m - 1][i], 1);
        
        // 处理其他格子
        for(int i = m - 2; i >= 0; i--)
        {
            for(int j = n - 2; j >= 0; j--)
            {
                // 选择当前元素下边和右边所需生命的较小值
                minHP[i][j] = Math.max(Math.min(minHP[i + 1][j], minHP[i][j + 1]) - dungeon[i][j], 1);
            }
        }
        return minHP[0][0];
    }
}

public class Solution {
    public int MinCost(int[,] costs) 
    {
        if(costs == null || costs.GetLength(0) == 0 || costs.GetLength(1) == 0)
            return 0;
        
        int n = costs.GetLength(0);
        for(int i = 1; i < n; i++)
        {
            costs[i, 0] = costs[i, 0] + Math.Min(costs[i - 1, 1], costs[i - 1, 2]);
            costs[i, 1] = costs[i, 1] + Math.Min(costs[i - 1, 0], costs[i - 1, 2]);
            costs[i, 2] = costs[i, 2] + Math.Min(costs[i - 1, 0], costs[i - 1, 1]);
        }
        return Math.Min(Math.Min(costs[n - 1, 0], costs[n - 1, 1]), costs[n - 1, 2]);
    }
}

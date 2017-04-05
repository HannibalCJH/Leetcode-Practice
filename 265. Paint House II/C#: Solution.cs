public class Solution {
    public int MinCostII(int[,] costs) 
    {
        if(costs == null || costs.GetLength(0) == 0 || costs.GetLength(1) == 0)
            return 0;
        
        int min1 = 0, min2 = 0, preIdx = -1;
        for(int i = 0; i < costs.GetLength(0); i++)
        {
            int cur1 = Int32.MaxValue, cur2 = Int32.MaxValue, curIdx = -1;
            for(int j = 0; j < costs.GetLength(1); j++)
            {
                costs[i, j] = costs[i, j] + (j == preIdx ? min2 : min1);
                if(costs[i, j] < cur1)
                {
                    cur2 = cur1;
                    cur1 = costs[i, j];
                    curIdx = j;
                }
                else if(costs[i, j] < cur2)
                {
                    cur2 = costs[i, j];
                }
            }
            min1 = cur1;
            min2 = cur2;
            preIdx = curIdx;
        }
        return min1;
    }
}

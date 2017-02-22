public class Solution {
    public int MaxProfit(int[] prices) 
    {
        if(prices == null || prices.Length == 0)
            return 0;
        int curMin = prices[0];
        int maxPro = 0;
        for(int i = 1; i < prices.Length; i++)
        {
            curMin = Math.Min(curMin, prices[i]);
            maxPro = Math.Max(maxPro, prices[i] - curMin);
        }
        return maxPro;
    }
}

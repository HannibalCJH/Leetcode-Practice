public class Solution {
    public int MaxProfit(int[] prices) 
    {
        if(prices == null || prices.Length < 2)
            return 0;
        
        int n = prices.Length;
        int[] preProfit = new int[n], postProfit = new int[n];
        preProfit[0] = 0; postProfit[n - 1] = 0;
        int curMin = prices[0], curMax = prices[n - 1];
        int maxPro = 0;
        for(int i = 1; i < n; i++)
        {
            curMin = Math.Min(curMin, prices[i]);
            preProfit[i] = Math.Max(preProfit[i - 1], prices[i] - curMin);
        }
        for(int i = n - 2; i >= 0; i--)
        {
            curMax = Math.Max(curMax, prices[i]);
            postProfit[i] = Math.Max(postProfit[i + 1], curMax - prices[i]);
        }
        for(int i = 0; i < n; i++)
        {
            maxPro = Math.Max(maxPro, preProfit[i] + postProfit[i]);
        }
        return maxPro;
    }
}

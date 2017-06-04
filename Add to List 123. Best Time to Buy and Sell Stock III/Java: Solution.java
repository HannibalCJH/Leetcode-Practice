public class Solution {
    // 时间复杂度O(n)，空间复杂度O(n)
    public int maxProfit(int[] prices) 
    {
        if(prices == null || prices.length < 2)
            return 0;
        
        int n = prices.length;
        // 因为只进行两次交易，以第i天为界分别计算之前和之后的最大收益
        // preProfit[i]记录第i天之前的一笔最大的收益，postProfit[i]记录第i天之后的一笔最大收益
        int[] preProfit = new int[n], postProfit = new int[n];
        preProfit[0] = 0; postProfit[n - 1] = 0;
        int curMin = prices[0], curMax = prices[n - 1];
        int maxPro = 0;
        // 计算preProfit数组，算法和Best Time to Buy and Sell Stock一样
        for(int i = 1; i < n; i++)
        {
            curMin = Math.min(curMin, prices[i]);
            preProfit[i] = Math.max(preProfit[i - 1], prices[i] - curMin);
        }
        // 倒序计算postProfit，维护一个从数组最后倒序的最大的价格curMax
        for(int i = n - 2; i >= 0; i--)
        {
            curMax = Math.max(curMax, prices[i]);
            postProfit[i] = Math.max(postProfit[i + 1], curMax - prices[i]);
        }
        for(int i = 0; i < n; i++)
        {
            maxPro = Math.max(maxPro, preProfit[i] + postProfit[i]);
        }
        return maxPro;
    }
}

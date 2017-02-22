public class Solution {
    // 时间复杂度O(n)，空间复杂度O(1)
    public int maxProfit(int[] prices) 
    {
        if(prices == null || prices.length < 2)
            return 0;
        // 到prices[i]为止最低的价格
        int curMin = prices[0];
        int maxPro = 0;
        for(int i = 1; i < prices.length; i++)
        {
            // 每次和prices[i]比较，更新最低价格
            curMin = Math.min(curMin, prices[i]);
            // 计算当天价格和最低价格的差价，如果差价比最大的大则更新
            maxPro = Math.max(maxPro, prices[i] - curMin);
        }
        return maxPro;
    }
}

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices or len(prices) < 2:
            return 0
        
        n = len(prices)
        preProfit = [0] * n
        postProfit = [0] * n
        curMin = prices[0]
        curMax = prices[-1]
        maxPro = 0
        
        for i in range(1, n):
            curMin = min(curMin, prices[i])
            preProfit[i] = max(preProfit[i - 1], prices[i] - curMin)
        for i in range(n - 2, 0, -1):
            curMax = max(curMax, prices[i])
            postProfit[i] = max(postProfit[i + 1], curMax - prices[i])
        for i in range(0, n):
            maxPro = max(maxPro, preProfit[i] + postProfit[i])
        return maxPro

class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices or len(prices) < 2:
            return 0
        
        maxPro, curMin = 0, prices[0]
        # 用prices[1:]截取从下标1到最后一位元素
        for price in prices[1:]:
            curMin = min(curMin, price)
            maxPro = max(maxPro, price - curMin)
        return maxPro

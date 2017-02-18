class Solution(object):
    # (76ms)
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        return sum([prices[i + 1] - prices[i] for i in xrange(len(prices) - 1) if prices[i + 1] > prices[i]])

    # (55ms)
    def maxProfit(self, prices):
        profit = 0
        for i in xrange(len(prices) - 1):
            profit += prices[i + 1] - prices[i] if prices[i + 1] > prices[i] else 0
        return profit


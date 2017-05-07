class Solution(object):
	# (176ms)
    def distributeCandies(self, candies):
        """
        :type candies: List[int]
        :rtype: int
        """
        return min(len(set(candies)), len(candies) / 2)
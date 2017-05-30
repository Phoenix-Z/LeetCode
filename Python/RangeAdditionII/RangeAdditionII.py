class Solution(object):
	# (48ms)
    def maxCount(self, m, n, ops):
        """
        :type m: int
        :type n: int
        :type ops: List[List[int]]
        :rtype: int
        """
        return reduce(lambda x, y: x * y, map(min, zip(*ops))) if ops else m * n

print Solution().maxCount(3, 3, [[2,2],[3,3]])
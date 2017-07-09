class Solution(object):
	# (108ms)
    def lastRemaining(self, n):
        """
        :type n: int
        :rtype: int
        """
        return 2*(1 + n/2 - self.lastRemaining(n/2)) if n > 1 else 1
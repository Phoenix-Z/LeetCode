class Solution(object):
	# (495ms)
    def judgeSquareSum(self, c):
        """
        :type c: int
        :rtype: bool
        """
        import math
        for a in xrange(int(math.sqrt(c)) + 1):
        	b = int(math.sqrt(c - a**2))
        	if c - a**2 == b**2:
        		return True
        return False

print Solution().judgeSquareSum(2)
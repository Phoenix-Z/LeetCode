import math

class Solution(object):
    # (62ms)
    def checkPerfectNumber(self, num):
        """
        :type num: int
        :rtype: bool
        """
        return sum([i + num / i for i in xrange(2, int(math.sqrt(num)) + 1) if num % i == 0]) + 1 == num if num > 1 else False

class Solution(object):
    # (65ms) Newton's Method
    def isPerfectSquare(self, num):
        """
        :type num: int
        :rtype: bool
        """
        val = num
        while val ** 2 > num:
            val = (val + num / val) / 2
        return val ** 2 == num

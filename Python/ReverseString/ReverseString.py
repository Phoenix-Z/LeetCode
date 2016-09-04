#一个简单的做法
class Solution(object):
    def reverseString(self, s):
		"""
        :type s: str
        :rtype: str
        """
		return s[::-1]

str = Solution()
print str.reverseString("hello")
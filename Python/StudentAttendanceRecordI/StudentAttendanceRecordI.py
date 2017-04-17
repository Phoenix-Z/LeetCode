class Solution(object):
	# (58ms)
    def checkRecord(self, s):
        """
        :type s: str
        :rtype: bool
        """
        return not ('L' * 3 in s or s.count('A') > 1)
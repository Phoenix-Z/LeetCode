class Solution(object):
    def reverseWords(self, s):
        """
        :type s: str
        :rtype: str
        """
		# (56ms)
        return ' '.join([t[::-1] for t in s.split(' ')])
		# (59ms)or something like below
		# return ' '.join(map(lambda x : x[::-1], s.split(' ')))
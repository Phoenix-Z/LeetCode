# coding:utf-8
class Solution(object):
    # (48ms)
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        ans = []
        self.helper('', 0, n, ans)
        return ans

    def helper(self, now, len_of_left, total_len, ans):
        if len(now) == total_len * 2:
            ans.append(now)
        if len_of_left < total_len:
            self.helper(now + '(', len_of_left + 1, total_len, ans)
        if len(now) - len_of_left < len_of_left:
            self.helper(now + ')', len_of_left, total_len, ans)

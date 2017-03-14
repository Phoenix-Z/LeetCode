class Solution(object):
    def reverseStr(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        ans = ''
        for i in xrange(0, len(s), k):
            end = min(i + k, len(s))
            ans += s[i:end][::-1] if (i / k) % 2== 0 else s[i:end]
        return ans
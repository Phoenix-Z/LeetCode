class Solution(object):
    # (402ms)
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        i, j = 0, 0
        while i < len(t) and j < len(s):
            if t[i] == s[j]:
                j += 1
            i += 1
        return j == len(s)

    # (122ms)
    def isSubsequence2(self, s, t):
        t = iter(t)
        return all(c in t for c in s)

test = Solution()
print test.isSubsequence('abc', 'ahbgdc')
print test.isSubsequence('axc', 'ahbgdc')
print test.isSubsequence('', 'ahbgdc')
print test.isSubsequence('b', 'c')



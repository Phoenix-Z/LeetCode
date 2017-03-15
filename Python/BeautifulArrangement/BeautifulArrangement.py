class Solution(object):

    ans = 0
    # (182ms)
    def countArrangement(self, N):
        """
        :type N: int
        :rtype: int
        """
        def helper(used, N, now):
            if now < 2:
                self.ans += 1
                return
            for i in xrange(1, N + 1):
                if used[i]:
                    continue
                if i % now == 0 or now % i == 0:
                    used[i] = True
                    helper(used, N, now - 1)
                    used[i] = False

        used = [False] * (N + 1)
        helper(used, N, N)
        return self.ans

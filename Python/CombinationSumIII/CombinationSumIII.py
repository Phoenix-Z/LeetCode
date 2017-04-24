class Solution(object):
	# (46ms)
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        def dfs(ans, now, nowK, nowN):
            if not (nowK or nowN):
                ans.append(now[:])
                return
            if nowK < 0 or nowN < 0:
                return
            for i in xrange(1 if len(now) == 0 else now[-1] + 1, 10):
                now.append(i)
                dfs(ans, now, nowK - 1, nowN - i)
                now.pop()
        ans = []
        dfs(ans, [], k, n)
        return ans
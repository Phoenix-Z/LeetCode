class Solution(object):
	# (125ms)
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        def helper(ans, now, candidates, target, pos):
            if target == 0:
                ans.append(now[:])
            if target <= 0:
                return
            for i in xrange(pos, len(candidates)):
                now.append(candidates[i])
                helper(ans, now, candidates, target - candidates[i], i)
                now.pop()
        ans = []
        helper(ans, [], candidates, target, 0)
        return ans
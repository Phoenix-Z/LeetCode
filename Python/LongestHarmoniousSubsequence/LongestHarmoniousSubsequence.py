class Solution(object):
	# (279ms)
    def findLHS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        import collections
        LHS, dt = 0, collections.Counter(nums)
        for k, v in dt.items():
        	now = max(dt[k - 1], dt[k + 1])
        	LHS = max(LHS, now + dt[k]) if now else LHS
        return LHS

print Solution().findLHS([1,3,2,2,5,2,3,7])

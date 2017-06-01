class Solution(object):
	# (82ms)
    def arrayNesting(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxLen, visited = -1, [False] * len(nums)
        for i in xrange(len(nums)):
        	if not visited[i]:
        		count, now = 0, i
        		while count == 0  or now != i:
        			visited[now] = True
        			count += 1
        			now = nums[now]
        		maxLen = max(maxLen, count)
        return maxLen
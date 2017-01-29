class Solution(object):
	# (72ms)
	# dynamic programming
	def maxSubArray(self, nums):
		"""
		:type nums: List[int]
		:rtype: int
		"""
		maxCur = nums[0]
		maxSum = maxCur
		for i in xrange(1, len(nums)):
			maxCur = max(maxCur + nums[i], nums[i])
			maxSum = max(maxCur, maxSum)
		return maxSum

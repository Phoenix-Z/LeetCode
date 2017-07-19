class Solution(object):
	# (255ms)
    def findMaxAverage(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: float
        """
        now = sum(nums[:k])
        head, tail, maxSum = k, 0, now
        while head < len(nums):
        	now = now - nums[tail] + nums[head]
        	maxSum = max(maxSum, now)
        	tail += 1
        	head += 1
        return maxSum / k

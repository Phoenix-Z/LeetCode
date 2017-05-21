import collections


class Solution(object):
	# (45ms)
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        dt = collections.Counter(nums)
        for i in xrange(dt[0]):
        	nums[i] = 0
        for i in xrange(dt[1]):
        	nums[i + dt[0]] = 1
        for i in xrange(dt[2]):
        	nums[i + dt[0] + dt[1]] = 2

nums = [1, 0]
Solution().sortColors(nums)
print nums
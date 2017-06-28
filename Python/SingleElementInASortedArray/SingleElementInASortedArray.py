class Solution(object):
	# (59ms)
    def singleNonDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left, right = 0, len(nums) / 2
        while left < right:
        	mid = (left + right) / 2
        	if nums[2 * mid] != nums[2 * mid + 1]:
        		right = mid
        	else:
        		left = mid + 1
        return nums[2 * left]
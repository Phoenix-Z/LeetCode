class Solution(object):
	# (42ms)
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = now_max = now_min = nums[0]
        for num in nums[1:]:
        	if num < 0:
        		now_max, now_min = now_min, now_max
        	now_max = max(num, num * now_max)
        	now_min = min(num, num * now_min)
        	res = max(res, now_max)
        return res


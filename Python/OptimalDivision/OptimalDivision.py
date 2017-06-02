class Solution(object):
	# (45ms)
    def optimalDivision(self, nums):
        """
        :type nums: List[int]
        :rtype: str
        """
        if len(nums) == 1:
        	return str(nums[0])
        elif len(nums) == 2:
        	return '%d/%d' % (nums[0], nums[1])
        else:
        	mid = ''
        	for num in nums[1:]:
        		mid += str(num) + '/'
        	return '%d/(%s)' % (nums[0], mid[:-1])
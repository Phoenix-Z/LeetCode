import numpy as np

class Solution(object):
	# (149ms)
    def matrixReshape(self, nums, r, c):
        """
        :type nums: List[List[int]]
        :type r: int
        :type c: int
        :rtype: List[List[int]]
        """
        m, n = len(nums), len(nums[0])
        if m * n != r * c:
            return nums
        reshaped, now = [], []
        for i in xrange(len(nums)):
            for j in xrange(len(nums[i])):
                now.append(nums[i][j])
                if len(now) == c:
                    reshaped.append(now)
                    now = []
        return reshaped
		
	# (189ms)
	def matrixReshape2(self, nums, r, c):
        try:
            return np.reshape(nums, (r, c)).tolist()
        except:
            return nums
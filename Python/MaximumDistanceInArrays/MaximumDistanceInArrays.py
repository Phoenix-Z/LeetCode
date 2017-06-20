class Solution(object):
	# (82ms)
    def maxDistance(self, arrays):
        """
        :type arrays: List[List[int]]
        :rtype: int
        """
        res, min_now, max_now = 0, arrays[0][0], arrays[0][-1]
        for array in arrays[1:]:
        	res = max(res, max_now - array[0], array[-1] - min_now)
        	min_now, max_now = min(min_now, array[0]), max(max_now, array[-1])
        return res
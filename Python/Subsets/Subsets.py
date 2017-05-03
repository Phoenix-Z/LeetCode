class Solution(object):
	# (66ms)
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        numsSize, ansSize = len(nums), 2 ** len(nums)
        ans = []
        for i in xrange(ansSize):
            now = []
            for j in xrange(numsSize):
                if (i >> j & 1) == 1:
                    now.append(nums[j])
            ans.append(now)
        return ans
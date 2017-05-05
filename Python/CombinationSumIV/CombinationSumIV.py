class Solution(object):
	# (72ms)
    def combinationSum4(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        combs = [1] + [0] * target
        for i in range(target + 1):
            for num in nums:
                if i >= num:
                    combs[i] += combs[i - num]
        return combs[-1]
                
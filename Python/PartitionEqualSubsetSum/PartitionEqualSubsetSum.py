class Solution(object):
	# (708ms)
    def canPartition(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        sum_of_nums = sum(nums)
        if sum_of_nums % 2 != 0:
            return False
        target, dp = sum_of_nums / 2, [True] + [False] * (sum_of_nums / 2)
        for num in nums:
            for i in range(num, target + 1)[::-1]:
                dp[i] = dp[i] | dp[i - num]
            if dp[target]:
                return True
        return dp[target]
        
# coding:utf-8
class Solution1(object):
    # 这是该问题的第一个做法，未通过的原因是超时
    def findTargetSumWays(self, nums, S):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """
        return self.helper(nums, 0, S)

    def helper(self, nums, now, S):
        if now == len(nums):
            if S:
                return 0
            else:
                return 1
        return self.helper(nums, now + 1, S - nums[now]) + \
            self.helper(nums, now + 1, S + nums[now])

    # 这个做法就是加了一个缓存来避免一些重复的操作，优化过的算法能够AC
    def find_target_sumways_with_memorization(self, nums, S):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """
        def findTarget(i, s):
            if (i, s) not in cache:
                r = 0
                if i == len(nums):
                    if s == 0:
                        r = 1
                else:
                    r = findTarget(i + 1, s - nums[i]) + findTarget(i + 1, s + nums[i])
                cache[(i, s)] = r
            return cache[(i, s)]

        cache = {}
        return findTarget(0, S)


class Solution(object):
    # 这是这个题目第二个解法，未通过的原因是超出了内存限制，这个体现在dp数组的申请上
    def findTargetSumWays(self, nums, s):
        """
        :type nums: List[int]
        :type S: int
        :rtype: int
        """
        sum_of_nums = sum(nums)
        return self.knapsack(nums, (s + sum_of_nums) / 2) if sum >= s and (s + sum_of_nums) % 2 == 0 else 0

    def knapsack(self, nums, target):
        dp = [1] + [0] * target
        for num in nums:
            i = target
            while i >= num:
                dp[i] += dp[i - num]
                i -= 1
        return dp[target]

class Solution3(object):
    # 这是所有解法中最快的一个，使用的是DP
    def findTargetSumWays(self, nums, S):
        if not nums:
            return 0
        dic = {nums[0]: 1, -nums[0]: 1} if nums[0] != 0 else {0: 2}
        for i in range(1, len(nums)):
            tdic = {}
            for d in dic:
                tdic[d + nums[i]] = tdic.get(d + nums[i], 0) + dic.get(d, 0)
                tdic[d - nums[i]] = tdic.get(d - nums[i], 0) + dic.get(d, 0)
            dic = tdic
        return dic.get(S, 0)


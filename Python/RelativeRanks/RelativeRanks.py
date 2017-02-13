# coding:utf-8
class Solution(object):
    # (588ms)
    # 由于index方法没有使用二分查找，所以时间复杂度变为了O(n^2)，效率较低
    def findRelativeRanks(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        sortedNums = sorted(nums, reverse=True)
        for i, num in enumerate(nums):
            pos = sortedNums.index(num)
            if pos == 0:
                nums[i] = "Gold Medal"
            elif pos == 1:
                nums[i] = "Silver Medal"
            elif pos == 2:
                nums[i] = "Bronze Medal"
            else:
                nums[i] = repr(pos + 1)
        return nums

    # (112ms)
    # 这个方法就是将数字以及位置存放在一个map中，然后访问map
    def findRelativeRanks2(self, nums):
        sort = sorted(nums)[::-1]
        rank = ["Gold Medal", "Silver Medal", "Bronze Medal"] + map(str, range(4, len(nums) + 1))
        return map(dict(zip(sort, rank)).get, nums)

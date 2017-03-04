# coding:utf-8
class Solution(object):
    # (52ms)
    # ref: http://keithschwarz.com/interesting/code/?dir=find-duplicate
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums or len(nums) < 2:
            return -1
        slow, fast = nums[0], nums[nums[0]]
        while slow != fast:
            slow = nums[slow]
            fast = nums[nums[fast]]

        fast = 0
        while slow != fast:
            slow = nums[slow]
            fast = nums[fast]
        return slow

    # (65ms)
    # binary search method
    def findDuplicate2(self, nums):
        if not nums or len(nums) < 2:
            return -1
        left, right = 0, len(nums)
        while left < right:
            mid, count = (left + right) / 2, 0
            for num in nums:
                if num <= mid:
                    count += 1
            if count > mid:
                right = mid
            else:
                left = mid + 1
        return left

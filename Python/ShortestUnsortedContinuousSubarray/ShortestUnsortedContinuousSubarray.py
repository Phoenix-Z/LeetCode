class Solution(object):
    # (95ms)
    def findUnsortedSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        left, right, sortedNums = 0, len(nums) - 1, sorted(nums[:])
        while left < len(nums):
            if nums[left] != sortedNums[left]:
                break
            left += 1
        while right >= 0:
            if nums[right] != sortedNums[right]:
                break
            right -= 1
        return right - left + 1 if left < right else 0

    # (149ms)
    def findUnsortedSubarray2(self, nums):
        begin, end, minNum, maxNum = -1, -2, nums[-1], nums[0]
        for i in xrange(1, len(nums)):
            maxNum, minNum = max(maxNum, nums[i]), min(minNum, nums[-i - 1])
            if maxNum > nums[i]:
                end = i
            if minNum < nums[-i - 1]:
                begin = len(nums) - i - 1
        return end - begin + 1

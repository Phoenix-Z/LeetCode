import random

class Solution(object):

    def __init__(self, nums):
        """
        
        :type nums: List[int]
        :type numsSize: int
        """
        self.nums = nums
        
    # (122ms)
    def pick(self, target):
        """
        :type target: int
        :rtype: int
        """
        ans, count = -1, 0
        for index, num in enumerate(self.nums):
            if num == target:
                if random.randint(0, count) == 0:
                    ans = index
                count += 1
        return ans
        


# Your Solution object will be instantiated and called as such:
# obj = Solution(nums)
# param_1 = obj.pick(target)
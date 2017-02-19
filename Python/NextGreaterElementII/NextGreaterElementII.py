class Solution(object):
    # (339ms)
    def nextGreaterElements(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        stack = []
        ans = [-1] * len(nums)
        for i in xrange(2 * len(nums)):
            while stack and nums[stack[-1]] < nums[i % len(nums)]:
                ans[stack.pop()] = nums[i % len(nums)]
            if i < len(nums):
                stack.append(i)
        return ans

test = Solution()
print test.nextGreaterElements([1, 2, 1])
print test.nextGreaterElements([5, 4, 3, 2, 1])

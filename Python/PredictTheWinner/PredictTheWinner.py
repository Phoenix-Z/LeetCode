class Solution(object):
    # (49ms)
    def PredictTheWinner(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        cache = {}

        def helper(nums, left, right):
            key = 'l' + `left` + 'r' + `right`
            if key not in cache:
                cache[key] = nums[left] if left == right else max(nums[left] - helper(nums, left + 1, right),
                                                                  nums[right] - helper(nums, left, right - 1))
            return cache[key]

        return helper(nums, 0, len(nums) - 1) >= 0

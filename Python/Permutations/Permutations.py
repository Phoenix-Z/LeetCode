class Solution(object):
    # (69ms)
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        def helper(ans, now, nums):
            if len(now) == len(nums):
                ans.append(now[:])
            for num in nums:
                if num not in now:
                    now.append(num)
                    helper(ans, now, nums)
                    now.pop()
        ans = []
        helper(ans, [], nums)
        return ans

    # (72ms) 迭代的做法
    def permute2(self, nums):
        ans = [[nums[0]]]
        for i in xrange(1, len(nums)):
            size = len(ans)
            while 0 < size:
                now = ans.pop(0)
                for j in xrange(len(now) + 1):
                    now.insert(j, nums[i])
                    ans.append(now[:])
                    now.pop(j)
                size -= 1
        return ans

test = Solution()
print test.permute2([1, 2, 3])

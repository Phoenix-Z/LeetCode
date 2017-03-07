import collections


class Solution(object):
    # (92ms)
    def findPairs(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        count = 0
        if nums and k >= 0:
            dt = collections.Counter(nums)
            if k == 0:
                count = len([key for key in dt if dt[key] >= 2])
            else:
                count = len([(key, key + k) for key in dt if (key + k) in dt])
        return count

    # (62ms)
    def findPairs2(self, nums, k):
        if k > 0:
            return len(set(nums) & set(n + k for n in nums))
        elif k == 0:
            return sum(v > 1 for v in collections.Counter(nums).values())
        else:
            return 0

test = Solution()
print test.findPairs([1, 2, 3, 4, 5], 1)
print test.findPairs2([3, 1, 4, 1, 5], 2)
print test.findPairs2([1, 3, 1, 5, 4], 0)


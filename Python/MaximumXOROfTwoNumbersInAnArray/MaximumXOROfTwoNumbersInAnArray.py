class Solution(object):
    # (202ms)
    def findMaximumXOR(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_xor, mask = 0, 0
        for i in range(32)[::-1]:
            mask |= (1 << i)
            xor = set()
            for num in nums:
                xor.add(num & mask)
            greedy = max_xor | (1 << i)
            for now in xor:
                if now ^ greedy in xor:
                    max_xor = greedy
        return max_xor

print Solution().findMaximumXOR([3, 10, 5, 2, 8, 25])

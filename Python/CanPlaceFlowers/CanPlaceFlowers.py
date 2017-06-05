class Solution(object):
	# (66ms)
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        available, left, right = 0, -2, 0
        while right < len(flowerbed):
        	while right < len(flowerbed) and flowerbed[right] == 0:
        		right += 1
        	available += (right - left - 1) / 2 if right == len(flowerbed) else (right - left - 2) / 2
        	print 'right: %d, left: %d, available: %d' % (right, left, available)
        	left = right
        	right += 1
        return n <= available

print Solution().canPlaceFlowers([1, 0, 0, 0, 1], 2)
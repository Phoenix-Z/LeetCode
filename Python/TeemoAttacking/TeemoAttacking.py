class Solution(object):
    # (88ms)
	# 时间复杂度为O(n), 空间复杂度为O(1)
    def findPoisonedDuration(self, timeSeries, duration):
        """
        :type timeSeries: List[int]
        :type duration: int
        :rtype: int
        """
        if not timeSeries:
            return 0
        left, total = timeSeries[0], duration
        for time in timeSeries:
            if time < left + duration:
                total += time - left
            else:
                total += duration
            left = time
        return total


print Solution().findPoisonedDuration([1, 4], 2)
print Solution().findPoisonedDuration([1, 2], 2)


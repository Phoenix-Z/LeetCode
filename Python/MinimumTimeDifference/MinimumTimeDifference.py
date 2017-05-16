class Solution(object):
	# (62ms)
    def findMinDifference(self, timePoints):
        """
        :type timePoints: List[str]
        :rtype: int
        """
        times = [False] * (24 * 60)
        for time in timePoints:
        	hour, minute = map(int, time.split(':'))
        	if times[hour * 60 + minute]:
        		return 0
        	times[hour * 60 + minute] = True

        minDiff, left, right, prev = 10000, -1, len(times) - 1, -1
        for i in xrange(len(times)):
        	if times[i]:
        		if left == -1:
        			left = i
        		if prev != -1:
        			minDiff = min(minDiff, i - prev)
        		prev = i

        while not times[right]:
        	right -= 1
        return min(minDiff, left + 24 * 60 - right)

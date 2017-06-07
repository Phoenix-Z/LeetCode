class Solution(object):
	# (92ms)
    def leastBricks(self, wall):
        """
        :type wall: List[List[int]]
        :rtype: int
        """
        dt,maxCount = {}, 0
        for row in wall:
        	now = 0
        	for width in row[:-1]:
        		now += width
        		dt[now] = dt.get(now, 0) + 1
        		maxCount = max(maxCount, dt[now])
        return len(wall) - maxCount

print Solution().leastBricks([[1,2,2,1], [3,1,2], [1,3,2], [2,4], [3,1,2], [1,3,1,1]])
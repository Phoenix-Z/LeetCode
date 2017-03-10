class Solution(object):
    # (262ms)
    def findMinArrowShots(self, points):
        """
        :type points: List[List[int]]
        :rtype: int
        """
        if not points:
            return 0
        points.sort(key=lambda x: x[0])
        arrows, now = 1, points[0][1]
        # print points
        for i in xrange(1, len(points)):
            now = min(now, points[i][1])
            if now >= points[i][0]:
                continue
            arrows += 1
            now = points[i][1]
        return arrows

    # (162ms)
    def findMinArrowShots2(self, points):
        points = sorted(points, key=lambda x: x[1])
        res, end = 0, -float('inf')
        for interval in points:
            if interval[0] > end:
                res += 1
                end = interval[1]
        return res


points = [[7, 15], [6, 14], [8, 12], [3, 4], [4, 13], [6, 14], [9, 11], [6, 12], [4, 13]]
print Solution().findMinArrowShots(points)

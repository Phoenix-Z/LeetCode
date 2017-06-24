# Definition for an interval.
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class Solution(object):
    # (309ms)
    # the module bisect is interesting
    def findRightInterval(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[int]
        """
        import bisect
        sorted_start = sorted([[interval.start, i] for i, interval in enumerate(intervals)] + [[float('inf'), -1]])
        return [sorted_start[bisect.bisect(sorted_start, [I.end])][1] for I in intervals]

interval2 = Interval(3, 4)
interval1 = Interval(2, 3)
interval3 = Interval(1, 2)
print Solution().findRightInterval([interval1, interval2, interval3])

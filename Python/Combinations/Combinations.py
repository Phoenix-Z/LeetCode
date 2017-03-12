# coding:utf-8
from itertools import combinations


class Solution(object):
    # (856ms)
    def combine(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        if k == 0:
            return [[]]
        # 加了这条限制之后，运行时间就缩减到295ms
        if k > n:
            return []
        return [pre + [i] for i in range(1, n + 1) for pre in self.combine(i - 1, k - 1)]

    # (322ms)
    # 这里使用的是iterators模块内置的combinations功能
    def combine2(self, n, k):
        return map(list, list(combinations(range(1, n + 1), k)))

test = Solution()
print test.combine(20, 16)

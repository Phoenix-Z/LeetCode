# coding:utf-8
class Solution(object):
    # (205ms)
    def findDiagonalOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        ans = []
        if not matrix:
            return ans
        m, n = len(matrix), len(matrix[0])
        for sum in xrange(m + n - 1):
            if sum % 2 == 0:
                i = min(sum, m - 1)
                j = sum - i
                while i >= 0 and j < n:
                    ans.append(matrix[i][j])
                    i -= 1
                    j += 1
            else:
                j = min(sum, n - 1)
                i = sum - j
                while j >= 0 and i < m:
                    ans.append(matrix[i][j])
                    i += 1
                    j -= 1
        return ans

		# (372ms)
		# 由于对角线上的i + j 是定值，那就根据先根据i+j排序，然后在根据和是否整除2来判断是行还是列来排序
		def findDiagonalOrder2(self, matrix):
			l = [(i, j) for i in range(len(matrix)) for j in range(len(matrix[0]))]
			l.sort(key=lambda x: sum(x) * 100000 - x[sum(x)%2])
			return [matrix[x][y] for x, y in l]
		
test = Solution()
matrix = [
 [1, 2, 3],
 [4, 5, 6],
 [7, 8, 9]
]
print test.findDiagonalOrder(matrix)

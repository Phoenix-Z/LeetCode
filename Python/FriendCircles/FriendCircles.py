class Solution(object):
	# (69ms)
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        def DFS(M, visited, rowNum):
            for i in xrange(len(M[rowNum])):
                if (M[rowNum][i] == 1) and not visited[i]:
                    visited[i] = True
                    DFS(M, visited, i)
        num, visited = 0, [False] * len(M)
        for i in xrange(len(M)):
            if not visited[i]:
                num += 1
                visited[i] = True
                DFS(M, visited, i)
        return num
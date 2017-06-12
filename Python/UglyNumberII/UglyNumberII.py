class Solution(object):
	# (215ms)
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        ugly, i, j, k = [1], 0, 0, 0
        while n > 1:
        	now = min(ugly[i] * 2, ugly[j] * 3, ugly[k] * 5)
        	if now == ugly[i] * 2:
        		i += 1
        	if now == ugly[j] * 3:
        		j += 1
        	if now == ugly[k] * 5:
        		k += 1
        	ugly.append(now)
        	n -= 1
        return ugly[-1]

print Solution().nthUglyNumber(5)
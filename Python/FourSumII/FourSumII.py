import collections
class Solution(object):
	# (422ms)
	# 这个做法与java中的是一致的
	def fourSumCount(self, A, B, C, D):
		AB = {}
		for x in A:
			for y in B:
				sum = x + y
				if sum not in AB:
					AB[sum] = 1
				else:
					AB[sum] += 1
		res = 0
		for x in C:
			for y in D:
				sum = -(x + y)
				if sum in AB:
					res += AB[sum]
		return res
		
	# (812ms)
	# 这就是上面的代码的简化版，但是效率相对较低
	def fourSumCount2(self, A, B, C, D):
		AB = collections.Counter([x + y for x in A for y in B])
		return sum([AB[-(x+y)] for x in C for y in D if -(x+y) in AB])
	
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]
print Solution().fourSumCount2(A, B, C, D)
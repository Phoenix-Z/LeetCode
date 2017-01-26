class Solution(object):
	# (45ms)
	# 这里使用的是牛顿法
	def mySqrt(self, x):
		"""
		:type x: int
		:rtype: int
		"""
		val = x
		while val * val > x:
			val = (val + x / val) / 2
		return val
import math
class Solution(object):
	# (39ms)
	def constructRectangle(self, area):
		"""
		:type area: int
		:rtype: List[int]
		"""
		width = int(math.sqrt(area))
		while area % width != 0:
			width -= 1
		return [area / width, width]

print Solution().constructRectangle(4)
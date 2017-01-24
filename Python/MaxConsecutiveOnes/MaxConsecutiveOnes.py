# coding=utf-8
# 由于输入只有0和1，所以可以考虑先将数组转化为字符串，再根据0进行分割，最后再找出最长的
# 连续的是1的字符串。显然这个方法不是最高的，但是只需要一行代码。
class Solution(object):
	def findMaxConsecutiveOnes(self, nums):
		"""
		:type nums: List[int]
		:rtype: int
		"""
		# (112ms)
		return max([s.count('1') for s in ''.join(map(str, nums)).split('0')])
		# 下面这个代码更加简洁
		# (106ms)
		# return max(map(len, ''.join(map(str, nums)).split('0')))
		
print Solution().findMaxConsecutiveOnes([1,1,0,0,1,1,1])
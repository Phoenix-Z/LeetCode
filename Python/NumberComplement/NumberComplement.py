class Solution(object):
	# (52ms)
	# 这个方法同java
	def findComplement(self, num):
		"""
		:type num: int
		:rtype: int
		"""
		count = 1
		while (num << count) & (1 << 31) == 0:
			count += 1
		return ~ num & ((1 << (32 - count)) - 1)
	
	# (32ms)
	# 这个方法更加直接一些
	def findComplement(self, num):
		i = 1
        while i <= num:
            i = i << 1
        return (i - 1) ^ num
		
print Solution().findComplement(5)
print Solution().findComplement(1)
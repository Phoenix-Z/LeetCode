class Solution(object):
	# (462ms)
	def magicalString(self, n):
		"""
		:type n: int
		:rtype: int
		"""
		magic, index = '122', 2
		while len(magic) < n:
			magic += `int(magic[-1]) ^ 3` * int(magic[index])
			index += 1
		return magic[:n].count('1') if n > 0 else 0
		
print Solution().magicalString(6)
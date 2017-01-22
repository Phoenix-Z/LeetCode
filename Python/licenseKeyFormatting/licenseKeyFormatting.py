class Solution(object):
	# (42ms)
	def licenseKeyFormatting(self, S, K):
		"""
		:type S: str
		:type K: int
		:rtype: str
		"""
		ans = list(S.replace('-', '').upper())
		index = len(ans) - K
		while index > 0:
			ans.insert(index, '-')
			index -= K
		return ''.join(ans)
		
print Solution().licenseKeyFormatting("2-4A0r7-4k", 4)
print Solution().licenseKeyFormatting("2-4A0r7-4k", 3)
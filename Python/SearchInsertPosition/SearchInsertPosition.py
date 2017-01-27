class Solution(object):
	# (54ms)
	def searchInsert(self, nums, target):
		"""
		:type nums: List[int]
		:type target: int
		:rtype: int
		"""
		left, right = 0, len(nums)
		while left < right:
			mid = (left + right) / 2
			if nums[mid] < target:
				left = mid + 1
			elif nums[mid] > target:
				right = mid
			else:
				return mid
		return left
		
test = Solution()
nums = [1,3,5,6]
print test.searchInsert(nums, 5)
print test.searchInsert(nums, 2)
print test.searchInsert(nums, 7)
print test.searchInsert(nums, 0)
print test.searchInsert([1,3], 2)
#(59ms)这个解法与Two Sum基本一致，使用的是dict
class Solution(object):
    def containsDuplicate(self, nums):
		"""
        :type nums: List[int]
        :rtype: bool
        """
		the_map = {}
		for num in nums:
			if the_map.get(num) != None:
				return True
			else:
				the_map[num] = True
		return False
			
test = Solution()
print test.containsDuplicate([1, 0, -1, 1])
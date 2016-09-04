#思路同java方法二
class Solution(object):
    def twoSum(self, nums, target):
		ans = [-1, -1]
		the_map = {}
		for i in range(0, len(nums)):
			key = target - nums[i]
			if the_map.get(key) != None:
				ans[0] = the_map[key]
				ans[1] = i
				return ans
			else:
				the_map[nums[i]] = i
		return ans
		
test = Solution()
print test.twoSum([2, 7, 11, 15], 9)
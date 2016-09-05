#(45ms)这个解法很优美，只有一行代码，与我在java中的第一个解法的想法是一样的
#将nums转换成set，如果set的长度小于nums的长度，则一定存在重复的元素
#与java不同的是，这种做法比使用dict更快。。。与java正好相反
class Solution(object):
    def containsDuplicate(self, nums):
		"""
        :type nums: List[int]
        :rtype: bool
        """
		return len(set(nums)) < len(nums)

test = Solution()
print test.containsDuplicate([1, 0, -1, 1])
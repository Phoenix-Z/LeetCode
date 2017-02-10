# coding:utf-8
class Solution(object):
    # (62ms)
    def nextGreaterElement(self, findNums, nums):
        """
        :type findNums: List[int]
        :type nums: List[int]
        :rtype: List[int]
        """
        stack, num_map = [], {}
        for num in nums:
            while stack and stack[-1] < num:
                num_map[stack.pop()] = num
            stack.append(num)
        for index, item in enumerate(findNums):
            findNums[index] = num_map.get(item, -1)
        return findNums

    # (192ms)
    # 从python这两个运行效率来看，java中的map实现的是较差的
    def nextGreaterElement2(self, findNums, nums):
        ans = []
        for num in findNums:
            i = 0
            while nums[i] != num:
                i += 1
            i += 1
            while i < len(nums):
                if nums[i] > num:
                    ans.append(nums[i])
                    break
                i += 1
            if i == len(nums):
                ans.append(-1)
        return ans

print Solution().nextGreaterElement([2, 4], [1, 2, 3, 4])
print Solution().nextGreaterElement2([2, 4], [1, 2, 3, 4])
print Solution().nextGreaterElement([4, 1, 2], [1, 3, 4, 2])
print Solution().nextGreaterElement2([4, 1, 2], [1, 3, 4, 2])

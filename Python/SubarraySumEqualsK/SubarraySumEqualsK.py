class Solution(object):
	# (62ms)
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        count, nowSum, prevSum = 0, 0, {0 : 1}
        for num in nums:
        	nowSum += num
        	if nowSum - k in prevSum:
        		count += prevSum[nowSum - k]
        	prevSum[nowSum] = prevSum[nowSum] + 1 if nowSum in prevSum else 1
        return count

print Solution().subarraySum([1, 1, 1], 2)
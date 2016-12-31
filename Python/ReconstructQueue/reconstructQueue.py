# (145ms)
# the thought is the same as the java solution.
class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
		ans = []
		for p in sorted(people, key = lambda x : (-x[0], x[1])):
			ans.insert(p[1], p)
		return ans
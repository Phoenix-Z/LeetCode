class Solution(object):
	# (322ms)
    def findDuplicate(self, paths):
        """
        :type paths: List[str]
        :rtype: List[List[str]]
        """
        dt = {}
        for path in paths:
        	parts = path.split()
        	for part in parts[1:]:
        		subparts = part.split('(')
        		if subparts[1] not in dt:
        			dt[subparts[1]] = [parts[0] + '/' + subparts[0]]
        		else:
        			dt[subparts[1]].append(parts[0] + '/' + subparts[0])
        ans = []
        for value in dt.itervalues():
        	if len(value) > 1:
        		ans.append(value)
        return ans



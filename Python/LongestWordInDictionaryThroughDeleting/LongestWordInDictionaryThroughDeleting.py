class Solution(object):
	# (922ms)
    def findLongestWord(self, s, d):
        """
        :type s: str
        :type d: List[str]
        :rtype: str
        """
        def issequence(s, ss):
        	i, j = 0, 0
        	while i < len(s) and j < len(ss):
        		if s[i] == ss[j]:
        			j += 1
        		i += 1
        	return j == len(ss)
        res = ''
        for ss in d:
            if len(ss) >= len(res) and issequence(s, ss) and (len(ss) > len(res) or ss < res):
                    res = ss
        return res
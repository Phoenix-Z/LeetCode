class Solution(object):
	# (129ms)
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        roman = ''
        if num >= 1000:
        	roman += 'M' * (num / 1000)
        	num %= 1000
        if num >= 100:
        	over_100 = ['C', 'CC', 'CCC', 'CD', 'D', 'DC', 'DCC', 'DCCC', 'CM']
        	roman += over_100[num / 100 - 1]
        	num %= 100
        if num >= 10:
        	over_10 = ['X', 'XX', 'XXX', 'XL', 'L', 'LX', 'LXX', 'LXXX', 'XC']
        	roman += over_10[num / 10 - 1]
        	num %= 10
        if num > 0:
        	over_0 = ['I', 'II', 'III', 'IV', 'V', 'VI', 'VII', 'VIII', 'IX']
        	roman += over_0[num - 1]
        return roman

print Solution().intToRoman(1984)
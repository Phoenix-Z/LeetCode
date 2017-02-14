class Solution(object):
    # (45ms)
    def convertToBase7(self, num):
        """
        :type num: int
        :rtype: str
        """
        if not num:
            return '0'
        sign = (num < 0)
        num = abs(num)
        res = ''
        while num != 0:
            num,  mod = divmod(num, 7)
            res += repr(mod)
        if sign:
            res += '-'
        return res[::-1]

print Solution().convertToBase7(100)
print Solution().convertToBase7(-7)

import re


class Solution(object):
    # (49ms)
    def detectCapitalUse(self, word):
        """
        :type word: str
        :rtype: bool
        """
        return word.isupper() or word.islower() or word.istitle()

    # (62ms)
    # 注意正则表达式需要加上^和$，而且 | 表示选项的需要加括号
    def detectCapitalUse2(self, word):
        """
        :type word: str
        :rtype: bool
        """
        return re.match('^([A-Z]+|[A-Z]?[a-z]+)$', word) is not None


test = Solution()
print test.detectCapitalUse2('FlaG')
print test.detectCapitalUse2('Flag')


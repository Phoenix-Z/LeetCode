# coding:utf-8
import re


class Solution(object):
    # (42ms)
    def findWords(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        ans = []
        keyboard = ['qwertyuiop', 'asdfghjkl', 'zxcvbnm']
        for word in words:
            for i in xrange(3):
                if sum([1 for letter in word.lower() if letter in keyboard[i]]) == len(word):
                    ans.append(word)
                    break
        return ans

    # (42ms)
    def findWords2(self, words):
        # 该方法使用的是正则表达式，(?i)表示的是忽略大小写
        return filter(re.compile('(?i)([qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*)$').match, words)

print Solution().findWords2(["Hello", "Alaska", "Dad", "Peace"])
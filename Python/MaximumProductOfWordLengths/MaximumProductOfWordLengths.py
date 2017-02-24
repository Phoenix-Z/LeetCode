class Solution(object):
    # (669ms)
    def maxProduct(self, words):
        """
        :type words: List[str]
        :rtype: int
        """
        bitDiff = [0] * len(words)
        for i, word in enumerate(words):
            for c in word:
                bitDiff[i] |= 1 << (ord(c) - ord('a'))
        max_product = max([len(words[i]) * len(words[j]) for i in xrange(len(bitDiff)) for j in xrange(len(bitDiff))
                           if (bitDiff[i] & bitDiff[j]) == 0] + [0])
        return max_product

test = Solution()
print test.maxProduct(["abcw", "baz", "foo", "bar", "xtfn", "abcdef"])
print test.maxProduct(["a", "ab", "abc", "d", "cd", "bcd", "abcd"])
print test.maxProduct(["a", "aa", "aaa", "aaaa"])


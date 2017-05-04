from operator import add, sub, mul

class Solution(object):
    # (66ms)
    def diffWaysToCompute(self, input):
        """
        :type input: str
        :rtype: List[int]
        """
        op, res = {'+': add, '-': sub, '*': mul}, []
        for i, c in enumerate(input):
            if c in op:
                left, right = self.diffWaysToCompute(input[:i]), self.diffWaysToCompute(input[i+1:])
                res += [op[c](l, r) for l in left for r in right]
        if not res:
            res = [int(input)]
        return res

if __name__ == '__main__':
    print Solution().diffWaysToCompute('2-1-1')

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):

    def __init__(self):
        self.maxCount = 0
        self.count = {}

    # (92ms)
    # 这个方法效率虽然比较高，但是在python中定义实例变量较为麻烦。
    def findFrequentTreeSum(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """

        def getSum(root):
            if not root:
                return 0
            nowSum = root.val + getSum(root.left) + getSum(root.right)
            if nowSum in self.count:
                self.count[nowSum] += 1
            else:
                self.count[nowSum] = 1
            self.maxCount = max(self.maxCount, self.count[nowSum])
            return nowSum

        ans = []
        getSum(root)
        for (key, value) in self.count.iteritems():
            if value == self.maxCount:
                ans.append(key)
        return ans

    # (96ms)
    # 这个方法效率也不错，而且代码更加简洁
    def findFrequentTreeSum2(self, root):
        if not root:
            return []

        def getSum(node):
            if not node:
                return 0
            s = node.val + getSum(node.left) + getSum(node.right)
            c[s] += 1
            return s

        from collections import Counter
        c = Counter()
        getSum(root)
        frequent = max(c.values())
        return [s for s in c.keys() if c[s] == frequent]

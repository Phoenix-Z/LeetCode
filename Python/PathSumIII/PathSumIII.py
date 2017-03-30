# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    # (1428ms)
    # this solution is much slower
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: int
        """
        if not root:
            return 0
        return self.helper(root, sum) + self.pathSum(root.left, sum) + self.pathSum(root.right, sum)

    def helper(self, nowNode, nowSum):
        if not nowNode:
            return 0
        res = 1 if nowNode.val == nowSum else 0
        res += self.helper(nowNode.left, nowSum - nowNode.val) \
            + self.helper(nowNode.right, nowSum - nowNode.val)
        return res

    # (126ms)
    # this solution is much better
    def pathSum2(self, root, sum):
        preSum = {0: 1}
        return self.helper2(root, 0, sum, preSum)

    def helper2(self, root, curSum, target, preSum):
        if not root:
            return 0
        curSum += root.val
        res = preSum.get(curSum - target, 0)
        preSum[curSum] = preSum.get(curSum, 0) + 1
        res += self.helper2(root.left, curSum, target, preSum)
        res += self.helper2(root.right, curSum, target, preSum)
        preSum[curSum] -= 1
        return res

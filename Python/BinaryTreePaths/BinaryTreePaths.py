# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    # (52ms)
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        def helper(root, ans, now):
            if not (root.left or root.right):
                ans.append(now + str(root.val))
                return
            now = now + str(root.val) + "->"
            if root.left:
                helper(root.left, ans, now)
            if root.right:
                helper(root.right, ans, now)

        ans = []
        if root:
            helper(root, ans, '')
        return ans

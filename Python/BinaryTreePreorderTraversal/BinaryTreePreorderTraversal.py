# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    # (38ms) recursive
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        def helper(root, nums):
            if not root:
                return
            nums.append(root.val)
            helper(root.left, nums)
            helper(root.right, nums)
        ans = []
        helper(root, ans)
        return ans

    # (42ms) iterative
    def preorderTraversal2(self, root):
        ans, stack = [], [root]
        while stack:
            root = stack.pop()
            if root:
                ans.append(root.val)
                # note that push right kid first
                stack.append(root.right)
                stack.append(root.left)
        return ans

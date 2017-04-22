# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    prevSum = 0
    # (122ms)
    def convertBST(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        def traverse(root):
            if not root:
                return
            traverse(root.right)
            root.val += self.prevSum
            self.prevSum = root.val
            traverse(root.left)
        traverse(root)
        return root
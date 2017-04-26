# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
	# (129ms)
    def findTilt(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def getSum(root, tilts):
            if not root:
                return 0
            left, right = getSum(root.left, tilts), getSum(root.right, tilts)
            tilts.append(abs(left - right))
            return root.val + left + right
        tilts = []
        getSum(root, tilts)
        return sum(tilts)
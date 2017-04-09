# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
	# (112ms)
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        def height(root):
	        if not root:
			    return 0
			return 1 + max(height(root.left), height(root.right))
		if not root:
		    return True
		return abs(height(root.left) - height(root.right)) <= 1 
		and self.isBalanced(root.left) and self.isBalanced(root.right)
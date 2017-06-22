# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
	# (75ms)
    def addOneRow(self, root, v, d):
        """
        :type root: TreeNode
        :type v: int
        :type d: int
        :rtype: TreeNode
        """
        if d == 1:
        	newRoot = TreeNode(v)
        	newRoot.left = root
        	return newRoot
        else:
        	self.dfs(root, v, d, 1)
        	return root

    def dfs(self, root, v, d, level):
    	if not root or level >= d:
    		return
    	elif level == d - 1:
    		newLeft, newRight = TreeNode(v), TreeNode(v)
    		newLeft.left, newRight.right = root.left, root.right
    		root.left, root.right = newLeft, newRight
    	else:
    		self.dfs(root.left, v, d, level + 1)
    		self.dfs(root.right, v, d, level + 1)

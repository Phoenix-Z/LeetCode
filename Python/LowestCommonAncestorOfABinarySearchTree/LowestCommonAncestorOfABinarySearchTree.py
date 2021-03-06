# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
	# (125ms) iteratively solution
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        while (root.val - p.val) * (root.val - q.val) > 0:
            root = root.left if p.val < root.val else root.right
        return root
		
	# (129ms)
	def lowestCommonAncestor2(self, root, p, q):
		return root if (root.val - p.val) * (root.val - q.val) <= 0 else \
		    self.lowestCommonAncestor(root.left if p.val < root.val else root.right, p, q)
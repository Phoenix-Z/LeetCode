# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
	# (148ms)
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        count = []
        self.dfs(root, count, k)
        return count[k - 1]

    def dfs(self, root, now, k):
    	if not root or len(now) == k:
    		return
    	self.dfs(root.left, now, k)
    	now.append(root.val)
    	self.dfs(root.right, now, k)
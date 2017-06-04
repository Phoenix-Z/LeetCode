# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
	# (95ms)
    def tree2str(self, t):
        """
        :type t: TreeNode
        :rtype: str
        """
        if not t:
        	return ''
        left, right = tree2str(t.left), tree2str(t.right)
        if not (left or right):
        	return str(t.val)
        return '%s(%s)(%s)' % (str(t.val), left, right)
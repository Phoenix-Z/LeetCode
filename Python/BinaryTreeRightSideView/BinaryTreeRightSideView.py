# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
	# (42ms)
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        ans, queue = [], [root]
        if root:
        	while queue:
	        	size = len(queue)
	        	for i in xrange(size):
	        		now = queue[i]
	        		if now.left:
	        			queue.append(now.left)
	        		if now.right:
	        			queue.append(now.right)
	        		if i == size - 1:
	        			ans.append(now.val)
	        	queue = queue[size:]
        return ans


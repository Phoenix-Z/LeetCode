# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
	# (52ms)
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        ans, queue = [], []
        if root:
            queue.append(root)
        while queue:
            now = []
            size = len(queue)
            for i in xrange(size):
                now.append(queue[i].val)
                if queue[i].left:
                    queue.append(queue[i].left)
                if queue[i].right:
                    queue.append(queue[i].right)
            queue = queue[size:]
            ans.append(now)
        return ans
        
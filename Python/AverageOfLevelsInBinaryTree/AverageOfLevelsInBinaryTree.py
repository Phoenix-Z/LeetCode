# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
	# (89ms)
    def averageOfLevels(self, root):
        """
        :type root: TreeNode
        :rtype: List[float]
        """
        def travasal(root, dt, level):
        	if not root:
        		return
        	if level not in dt:
        		dt[level] = [root.val]
        	else:
        		dt[level].append(root.val)
        	travasal(root.left, dt, level + 1)
        	travasal(root.right, dt, level + 1)
        nums_in_each_level = {}
        travasal(root, nums_in_each_level, 0)
        return [sum(nums_in_each_level[i]) * 1.0 / len(nums_in_each_level[i]) for i in xrange(len(nums_in_each_level))]
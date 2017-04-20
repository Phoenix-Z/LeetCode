# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
	# (88ms)
    def findBottomLeftValue(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def traverse(root, treeVal, level):
            if not root:
                return
            if level >= len(treeVal):
                treeVal.append([root.val])
            else:
                treeVal[level].append(root.val)
            traverse(root.left, treeVal, level + 1)
            traverse(root.right, treeVal, level + 1)
        treeVal = []
        traverse(root, treeVal, 0)
        return treeVal[-1][0]
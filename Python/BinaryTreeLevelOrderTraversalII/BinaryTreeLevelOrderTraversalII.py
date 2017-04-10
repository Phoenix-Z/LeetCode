# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
	#(58ms)
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        def helper(root, ans, level):
            if not root:
                return
            if level >= len(ans):
                ans.append([])
            ans[level].append(root.val)
            helper(root.left, ans, level + 1)
            helper(root.right, ans, level + 1)
        ans = []
        helper(root, ans, 0);
        return ans[::-1]
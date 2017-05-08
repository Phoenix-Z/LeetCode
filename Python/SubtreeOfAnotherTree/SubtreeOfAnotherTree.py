# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
# (119ms)
    def isSubtree(self, s, t):
        """
        :type s: TreeNode
        :type t: TreeNode
        :rtype: bool
        """
        def traverse(root, now):
            if not root:
                now.append("$")
                return
            now.append(`root.val`)
            traverse(root.left, now)
            traverse(root.right, now)
        s_list, t_list = [], []
        traverse(s, s_list)
        traverse(t, t_list)
        s_str, t_str= "," + ",".join(s_list), "," + ",".join(t_list)
        return t_str in s_str
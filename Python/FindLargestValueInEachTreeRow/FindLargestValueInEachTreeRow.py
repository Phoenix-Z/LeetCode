# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    # (76ms)
    def largestValues(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        def traverse(node, now, level):
            if not node:
                return
            if level >= len(now):
                now.append(node.val)
            else:
                now[level] = max(node.val, now[level])
            traverse(node.left, now, level + 1)
            traverse(node.right, now, level + 1)
        ans = []
        traverse(root, ans, 0)
        return ans

root = TreeNode(1)
root.left = TreeNode(3)
root.right = TreeNode(2)
root.left.left = TreeNode(5)
root.left.right = TreeNode(3)
root.right.right = TreeNode(9)

test = Solution()
print test.largestValues(root)

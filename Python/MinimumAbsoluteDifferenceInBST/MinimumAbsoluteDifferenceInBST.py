# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    #(86ms)
    def getMinimumDifference(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        nums = []

        def helper(root, nums):
            if not root:
                return
            helper(root.left, nums)
            nums.append(root.val)
            helper(root.right, nums)

        helper(root, nums)
        return min([nums[i] - nums[i - 1] for i in xrange(1, len(nums))])

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * (156ms)
 * @param {TreeNode} root
 * @return {number[]}
 */
var rightSideView = function(root) {
    var ans = [];
    if(root != null) {
        var queue = [];
        queue.push(root);
        while (queue.length > 0) {
            var size = queue.length;
            for (let i = 0; i < size; i++) {
                var now = queue.shift();
                if (now.left != null)
                    queue.push(now.left);
                if (now.right != null)
                    queue.push(now.right);
                if (i == size - 1)
                    ans.push(now.val);
            }
        }
    }
    return ans;
};
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * (126ms)
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    var ans = [];
    var queue = [];
    if(root !== null)
        queue.push(root);
    while(queue.length > 0) {
        var now = [];
        var size = queue.length;
        while(0 < size--) {
            var node = queue.shift();
            now.push(node.val);
            if(node.left !== null)
                queue.push(node.left);
            if(node.right !== null)
                queue.push(node.right);
        }
        ans.push(now);
    }
    return ans;
};
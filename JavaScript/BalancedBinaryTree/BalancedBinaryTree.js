/**
 * Created by Phoenix-Z on 2017/4/9.
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * (172ms)
 * @param {TreeNode} root
 * @return {boolean}
 */
var isBalanced = function(root) {
    if(root === null)
        return true;
    return Math.abs(height(root.left) - height(root.right)) <= 1
        && isBalanced(root.left) && isBalanced(root.right);
};

var height = function (root) {
    if(root === null)
        return 0;
    return 1 + Math.max(height(root.left), height(root.right));
};
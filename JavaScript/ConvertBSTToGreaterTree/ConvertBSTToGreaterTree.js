/**
 * Created by Phoenix-Z on 2017/4/21.
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * (215ms)
 * @param {TreeNode} root
 * @return {TreeNode}
 */

var convertBST = function(root) {
    var traverse = function (root) {
        if(root === null)
            return;
        traverse(root.right);
        root.val += prevSum;
        prevSum = root.val;
        traverse(root.left);
    };
    var prevSum = 0;
    traverse(root);
    return root;
};


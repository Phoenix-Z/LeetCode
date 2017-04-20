/**
 * Created by Phoenix-Z on 2017/4/20.
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * (139ms)
 * @param {TreeNode} root
 * @return {number}
 */
var findBottomLeftValue = function(root) {
    var treeVal = [];
    traverse(root, treeVal, 0);
    return treeVal.pop().shift();
};

var traverse = function (root, treeVal, level) {
    if(root === null)
        return;
    if(level >= treeVal.length) {
        var now = [root.val];
        treeVal.push(now);
    } else {
        treeVal[level].push(root.val);
    }
    traverse(root.left, treeVal, level + 1);
    traverse(root.right, treeVal, level + 1);
};
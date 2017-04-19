/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * (195ms)
 * @param {TreeNode} root
 * @return {number[]}
 */
var largestValues = function(root) {
    ans = [];
    traverse(root, ans, 0);
    return ans;
};

var traverse = function(root, ans, level) {
    if(root === null)
        return;
    if(level >= ans.length)
        ans.push(root.val);
    else
        ans[level] = Math.max(ans[level], root.val);
    traverse(root.left, ans, level + 1);
    traverse(root.right, ans, level + 1);
}
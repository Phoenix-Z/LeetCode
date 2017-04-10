/**
 * Created by Phoenix-Z on 2017/4/10.
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * (179ms)
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrderBottom = function(root) {
    var ans = [];
    helper(root, ans, 0);
    return ans.reverse();
};

var helper = function(root, ans, level) {
    if(root === null)
        return;
    if(ans[level] === undefined)
        ans[level] = [];
    ans[level].push(root.val);
    helper(root.left, ans, level + 1);
    helper(root.right, ans, level + 1);
};
/**
 * Created by Phoenix-Z on 2017/4/8.
 */
// Definition for a binary tree node.
function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}
/**
 * @param {TreeNode} root
 * @return {string[]}
 */
// (186ms)
var binaryTreePaths = function(root) {
    var helper = function (root, ans, now) {
        if(root.left === null && root.right === null) {
            ans.push(now + root.val);
            return;
        }
        now += root.val + "->";
        if(root.left !== null)
            helper(root.left, ans, now);
        if(root.right !== null)
            helper(root.right, ans, now);
    };
    var ans = [];
    if(root !== null)
        helper(root, ans, "");
    return ans;
};

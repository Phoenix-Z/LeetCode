/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * (168ms)
 * @param {TreeNode} root
 * @return {number}
 */
var findTilt = function(root) {
    var tilt = 0;
    getSum = function(root) {
      if(root === null)  
        return 0;
      var left = getSum(root.left);
      var right = getSum(root.right);
      tilt += Math.abs(left - right);
      return root.val + left +right;
    };
    getSum(root);
    return tilt;
};
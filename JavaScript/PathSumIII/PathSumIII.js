/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {number}
 */
// (168ms)
var pathSum = function(root, sum) {
    if(root === null)
        return 0;
    return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
};

var helper = function(root, sum) {
        if(root === null)
            return 0;
        var res = 0;
        if(root.val === sum)
            res++;
        res += helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
        return res;
};

// (232ms)
// 可见javascript的map效率多慢
var pathSum2 = function(root, sum){
    var preSum = new Map();
    preSum.set(0, 1);
    return helper2(root, 0, sum, preSum);
};

var helper2 = function(root, curSum, sum, preSum) {
    if(root === null)
        return 0;
    curSum += root.val;
    var res = 0;
    if(preSum.has(curSum - sum))
        res += preSum.get(curSum - sum);
    if(preSum.has(curSum)) {
        preSum.set(curSum, preSum.get(curSum) + 1);
    } else {
        preSum.set(curSum, 1);
    }
    res += helper2(root.left, curSum, sum, preSum);
    res += helper2(root.right, curSum, sum, preSum);
    preSum.set(curSum, preSum.get(curSum) - 1);
    return res;
};
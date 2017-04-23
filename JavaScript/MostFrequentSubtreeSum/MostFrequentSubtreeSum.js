/**
 * Created by Phoenix-Z on 2017/4/23.
 */
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * (229ms)
 * @param {TreeNode} root
 * @return {number[]}
 */
var findFrequentTreeSum = function(root) {
    var count = new Map();
    var maxCount = 0;
    var getSum = function (root) {
        if(root === null)
            return 0;
        var sum = root.val + getSum(root.left) + getSum(root.right);
        if(count.has(sum)) {
            count.set(sum, count.get(sum) + 1);
        } else {
            count.set(sum, 1);
        }
        maxCount = Math.max(maxCount, count.get(sum));
        return sum;
    };
    var ans = [];
    getSum(root);
    count.forEach(function (value, key) {
        if(value === maxCount)
            ans.push(key);
    }, count);
    return ans;
};

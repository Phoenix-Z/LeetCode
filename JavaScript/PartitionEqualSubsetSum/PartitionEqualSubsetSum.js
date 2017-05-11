/**
 * (289ms)
 * @param {number[]} nums
 * @return {boolean}
 */
var canPartition = function(nums) {
    var sum = nums.reduce((x, y) => x + y);
    if(sum % 2!== 0) {
        return false;
    }
    var target = sum / 2;
    var dp = new Array(target + 1);
    dp.fill(false);
    dp[0] = true;
    for(var num of nums) {
        for(var i = target; i >= num; i--) {
            dp[i] = dp[i] || dp[i - num];
        }
    }
    return dp[target];
};
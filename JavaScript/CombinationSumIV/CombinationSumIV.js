/**
 * (99ms)
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var combinationSum4 = function(nums, target) {
    var comb = new Array(target + 1);
    comb.fill(0);
    comb[0] = 1;
    for (var i = 1; i < comb.length; i++) {
        for (var j = 0; j < nums.length; j++) {
            if (i - nums[j] >= 0) {
                comb[i] += comb[i - nums[j]];
            }
        }
    }
    return comb[target];
};
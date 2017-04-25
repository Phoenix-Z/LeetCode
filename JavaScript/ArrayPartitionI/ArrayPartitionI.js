/**
 * (239ms)
 * @param {number[]} nums
 * @return {number}
 */
var arrayPairSum = function(nums) {
    return nums.sort((x, y) => x - y).reduce((acc, val, index) => index % 2 === 0 ? acc + val : acc, 0);
};
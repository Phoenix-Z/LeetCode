/**
 * @param {number[]} nums
 * @return {boolean}
 * 注意获取Set中值的个数应使用size,而不是length
 */
var containsDuplicate = function(nums) {
    var s = new Set(nums);
    return s.size < nums.length;
};
/**
 * Created by Phoenix-Z on 2017/5/1.
 */
/**
 * (186ms)
 * @param {number[][]} nums
 * @param {number} r
 * @param {number} c
 * @return {number[][]}
 */
var matrixReshape = function(nums, r, c) {
    var m = nums.length, n = nums[0].length;
    if(r *c !== m * n)
        return nums;
    var reshaped = [];
    var now = [];
    for(var i = 0; i < m; i++) {
        for(var j = 0; j < n; j++) {
            now.push(nums[i][j]);
            if(now.length == c) {
                reshaped.push(now);
                now = [];
            }
        }
    }
    return reshaped;
};
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
// (445ms)
var findPairs = function(nums, k) {
    var map = new Map(), count = 0;
    nums.forEach(function(item) {
        if(map.has(item)) {
            map.set(item, map.get(item) + 1);
        } else {
            map.set(item, 1);
        }
    });
    for(var [key, value] of map) {
        if(k == 0) {
            if(value > 1) {
                count++;
            }
        }
        if(k > 0) {
            if(map.has(key + k)) {
                count++;
            }
        }
    }
    return count;
};
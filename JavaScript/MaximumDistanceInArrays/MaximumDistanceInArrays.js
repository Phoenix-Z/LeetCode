/**
 * (128ms)
 * @param {number[][]} arrays
 * @return {number}
 */
var maxDistance = function(arrays) {
    var res = 0;
    var min = arrays[0][0], max = arrays[0][arrays[0].length - 1];
    for (var i = 1; i < arrays.length; i++) {
    	res = Math.max(res, max - arrays[i][0], arrays[i][arrays[i].length - 1] - min);
    	min = Math.min(min, arrays[i][0]);
    	max = Math.max(max, arrays[i][arrays[i].length - 1]);
    }
    return res;
};
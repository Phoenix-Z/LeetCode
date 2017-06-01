/**
 * (145ms)
 * @param {number[]} nums
 * @return {number}
 */
var arrayNesting = function(nums) {
    var max = -1, visited = new Array(nums.length);
    visited.fill(false);
    for(var i = 0; i < nums.length; i++) {
    	if(!visited[i]) {
    		var count = 0, now = i;
    		while(now !== i || count === 0) {
    			visited[now] = true;
    			count++;
    			now = nums[now];
    		}
    		max = Math.max(max, count);
    	}
    }
    return max;
};
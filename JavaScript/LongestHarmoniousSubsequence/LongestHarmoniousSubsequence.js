/**
 * (472ms)
 * @param {number[]} nums
 * @return {number}
 */
var findLHS = function(nums) {
    var counter = new Map();
    for(var num of nums) {
    	if(counter.has(num))
	    	counter.set(num, counter.get(num) + 1);
	    else
	    	counter.set(num, 1);
    }
    var LHS = 0;
    for(var [key, value] of counter) {
    	if(!counter.has(key + 1) && !counter.has(key - 1)) {
    		continue;
    	}
    	var before = 0, after = 0;
    	if(counter.has(key - 1))
    		before = counter.get(key - 1);
    	if(counter.has(key + 1))
    		after = counter.get(key + 1);
    	LHS = Math.max(LHS, Math.max(before, after) + value);
    }
    return LHS;
};
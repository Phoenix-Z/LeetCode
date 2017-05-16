/**
 * (128ms)
 * @param {string[]} timePoints
 * @return {number}
 */
var findMinDifference = function(timePoints) {
    var times = new Array(24 * 60);
    times.fill(false);
    for(var time of timePoints) {
    	var parts = time.split(':');
    	var hour = Number(parts[0]), minute = Number(parts[1]);
    	if(times[hour * 60 + minute])
    		return 0;
    	times[hour * 60 + minute] = true;
    }
    var min = 10000, left = -1, right = times.length, prev = -1;
    for(var i = 0; i < times.length; i++) {
    	if(times[i]) {
    		if(left == -1)
    			left = i;
    		if(prev != -1)
    			min = Math.min(min, i - prev);
    		prev = i;
    	}
    }
    while(!times[right]) {
    	right--;
    }
    return Math.min(min, left + 24 * 60 - right);
};
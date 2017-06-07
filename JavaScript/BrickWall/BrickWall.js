/**
 * (276ms)
 * @param {number[][]} wall
 * @return {number}
 */
var leastBricks = function(wall) {
    var count = new Map(), max = 0;
    for(var row of wall) {
    	var now = 0;
    	for(var i = 0; i < row.length - 1; i++) {
    		now += row[i];
    		if(count.has(now)) {
    			count.set(now, count.get(now) + 1);
    		} else {
    			count.set(now, 1);
    		}
    		max = Math.max(max, count.get(now));
    	}
    	console.log(count);
    }
    return wall.length - max;
};
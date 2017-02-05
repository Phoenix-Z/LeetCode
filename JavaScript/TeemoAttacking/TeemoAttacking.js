/**
 * @param {number[]} timeSeries
 * @param {number} duration
 * @return {number}
 */
// (109ms)
var findPoisonedDuration = function(timeSeries, duration) {
    if(timeSeries.length === 0) {
        return 0;
    }
    var left = timeSeries[0];
	var total = duration;
	timeSeries.forEach(function(item){
		total += item < left + duration ? item - left : duration;
		left = item;
	});
	return total;
};
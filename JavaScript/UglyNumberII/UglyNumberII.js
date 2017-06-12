/**
 * (162ms)
 * @param {number} n
 * @return {number}
 */
var nthUglyNumber = function(n) {
    var ugly = [1];
    var i = 0, j = 0, k = 0;
    for(var r = 1; r < n; r++) {
    	var now = Math.min(ugly[i] * 2, ugly[j] * 3, ugly[k] * 5);
    	if(now == ugly[i] * 2)
    		i++;
    	if(now == ugly[j] * 3)
    		j++;
    	if(now == ugly[k] * 5)
    		k++;
    	ugly.push(now);
    }
    return ugly[n - 1];
};
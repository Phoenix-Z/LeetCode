/**
 * (119ms)
 * @param {number} c
 * @return {boolean}
 */
var judgeSquareSum = function(c) {
    for(let i = 0; i <= Math.sqrt(c); i++) {
    	if(isSquare(c - i * i))
    		return true;
    }
    return false;
};

var isSquare = function(num) {
	return num == Math.pow(Math.floor(Math.sqrt(num)), 2);
}
/**
 * @param {number} num
 * @return {string}
 */
 // (112ms)
var convertToBase7 = function(num) {
	if(num == 0) {
		return '0';
	}
    var sign = (num < 0);
	var res = '';
	num = Math.abs(num);
	while(num != 0) {
		res = num % 7 + res;
		num = Math.floor(num / 7);
	}
	return sign ? '-' + res : res;
};
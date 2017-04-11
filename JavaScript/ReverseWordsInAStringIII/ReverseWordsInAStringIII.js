/**
 * (202ms)
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    return s.split(' ').map(function(item) {return item.split('').reverse().join('')}).join(' ');
	// shorter
	// return s.split(' ').map(item => item.split('').reverse().join('')).join(' ')
};
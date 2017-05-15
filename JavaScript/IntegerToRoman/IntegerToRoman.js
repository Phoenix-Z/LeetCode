/**
 * (208ms)
 * @param {number} num
 * @return {string}
 */
var intToRoman = function(num) {
    var roman = '';
    if(num >= 1000) {
    	over_1000 = ['M', 'MM', 'MMM'];
       	roman += over_1000[Math.floor(num / 1000) - 1];
       	num %= 1000;
    }
    if(num >= 100) {
        over_100 = ['C', 'CC', 'CCC', 'CD', 'D', 'DC', 'DCC', 'DCCC', 'CM'];
       	roman += over_100[Math.floor(num / 100) - 1];
       	num %= 100;
    }
    if(num >= 10) {
      	over_10 = ['X', 'XX', 'XXX', 'XL', 'L', 'LX', 'LXX', 'LXXX', 'XC'];
       	roman += over_10[Math.floor(num / 10) - 1];
       	num %= 10;
    }
    if(num > 0) {
        over_0 = ['I', 'II', 'III', 'IV', 'V', 'VI', 'VII', 'VIII', 'IX'];
        roman += over_0[num - 1];
    }
    return roman;
};

console.log(intToRoman(3999));
/**
 * @param {number} num
 * @return {boolean}
 */
// (99ms)
var checkPerfectNumber = function(num) {
    if(num === 1)
        return false;
    var sum = 1;
    for(let i = 2; i * i <= num; i++) {
        if(num % i === 0) 
            sum += i + num / i;
    }
    return sum === num;
};
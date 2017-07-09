/**
 * (172ms)
 * @param {number} n
 * @return {number}
 */
var lastRemaining = function(n) {
    return n === 1 ? 1 : 2 * (1 + Math.floor(n/2) - lastRemaining(Math.floor(n/2)));
};

console.log(lastRemaining(9));
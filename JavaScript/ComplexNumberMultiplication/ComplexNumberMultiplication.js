/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
 // (102ms)
var complexNumberMultiply = function(a, b) {
    var numA = a.slice(0,-1).split('+').map(Number);
    var numB = b.slice(0,-1).split('+').map(Number);
    var real = numA[0]*numB[0] - numA[1]*numB[1];
    var virtual = numA[0]*numB[1] + numA[1]*numB[0];
    return `${real}+${virtual}i`;
};
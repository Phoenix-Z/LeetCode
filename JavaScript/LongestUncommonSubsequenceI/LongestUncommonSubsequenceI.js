/**
 * @param {string} a
 * @param {string} b
 * @return {number}
 */
 // (85ms)
var findLUSlength = function(a, b) {
    return a === b ? -1 : Math.max(a.length, b.length);
};
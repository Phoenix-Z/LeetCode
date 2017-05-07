/**
 * (356ms)
 * @param {number[]} candies
 * @return {number}
 */
var distributeCandies = function(candies) {
    return Math.min(candies.length / 2, new Set(candies).size);
};
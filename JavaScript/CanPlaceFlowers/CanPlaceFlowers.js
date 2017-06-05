/**
 * (122ms)
 * @param {number[]} flowerbed
 * @param {number} n
 * @return {boolean}
 */
var canPlaceFlowers = function(flowerbed, n) {
    var available = 0, left = -2, right = 0;
    while (right < flowerbed.length) {
        while (right < flowerbed.length && flowerbed[right] == 0) {
            right++;
        }
        available += right == flowerbed.length ? Math.floor((right - left - 1) / 2) 
        										: Math.floor((right - left - 2) / 2);
        left = right;
        right++;
    }
    return n <= available;
};
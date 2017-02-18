/**
 * @param {number[]} prices
 * @return {number}
 */
// (119ms)
var maxProfit = function(prices) {
    var profit = 0;
    for(let i = 0; i < prices.length - 1; i++) {
        if(prices[i + 1] > prices[i]) {
            profit += prices[i + 1] - prices[i];
        }
    }
    return profit;
};
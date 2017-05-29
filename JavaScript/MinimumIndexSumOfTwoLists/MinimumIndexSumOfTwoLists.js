/**
 * (212ms)
 * @param {string[]} list1
 * @param {string[]} list2
 * @return {string[]}
 */
var findRestaurant = function(list1, list2) {
    var map = new Map();
    for(var i = 0; i < list1.length; i++) {
    	map.set(list1[i], i);
    }
    var ans = [], minSum = list1.length + list2.length;
    for(i = 0; i < list2.length; i++) {
    	if(map.has(list2[i])) {
    		if(i + map.get(list2[i]) < minSum) {
    			ans = [];
    			ans.push(list2[i]);
    			minSum = i + map.get(list2[i]);
    		} else if(i + map.get(list2[i]) == minSum) {
    			ans.push(list2[i]);
    		}
    	}
    }
    return ans;
};
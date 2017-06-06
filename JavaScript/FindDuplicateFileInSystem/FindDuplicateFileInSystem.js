/**
 * (345ms)
 * @param {string[]} paths
 * @return {string[][]}
 */
var findDuplicate = function(paths) {
    var dict = {};
    for(var path of paths) {
    	var parts = path.split(' ');
    	for(var i = 1; i < parts.length; i++) {
    		var subparts = parts[i].split('(');
    		if(dict.hasOwnProperty(subparts[1])) {
    			dict[subparts[1]].push(parts[0] + '/' + subparts[0]);
    		} else {
    			dict[subparts[1]] = [parts[0] + '/' + subparts[0]];
    		}
    	}
    }
    var ans = [];
    for(var value of Object.values(dict)) {
    	if(value.length > 1)
    		ans.push(value);
    }
    return ans;
};
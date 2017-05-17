/**
 * (465ms)
 * @param {number[]} pid
 * @param {number[]} ppid
 * @param {number} kill
 * @return {number[]}
 */
var killProcess = function(pid, ppid, kill) {
    var kids = new Map();
    for(var i = 0; i < ppid.length; i++) {
    	if(kids.has(ppid[i])) {
    		kids.get(ppid[i]).push(pid[i]);
    	} else {
    		kids.set(ppid[i], [pid[i]]);
    	}
    }
    var queue = [kill], ans = [];
    while(queue.length > 0) {
    	var cur = queue.shift();
    	ans.push(cur);
    	if(kids.has(cur)) {
    		queue = queue.concat(kids.get(cur));
    	}
    }
    return ans;
};
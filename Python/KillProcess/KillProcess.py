class Solution(object):
	# (579ms)
    def killProcess(self, pid, ppid, kill):
        """
        :type pid: List[int]
        :type ppid: List[int]
        :type kill: int
        :rtype: List[int]
        """
        kids = {}
        for index, num in enumerate(ppid):
        	if num in kids:
        		kids[num].append(pid[index])
        	else:
        		kids[num] = [pid[index]]

        queue, ans = [kill], []
        while queue:
        	cur = queue.pop()
        	ans.append(cur)
        	if cur in kids:
        		queue += kids[cur]
        return ans

pid, ppid = [1, 3, 5, 10], [3, 0, 3, 5]
print Solution().killProcess(pid, ppid, 5)

class Solution(object):
	# (122ms)
    def findRestaurant(self, list1, list2):
        """
        :type list1: List[str]
        :type list2: List[str]
        :rtype: List[str]
        """
        dt, ans, minSum = {}, [], len(list1) + len(list2)
        for index, s in enumerate(list1):
        	dt[s] = index
        for index, s in enumerate(list2):
        	if s in dt:
        		if index + dt[s] > minSum:
        			continue
        		if index + dt[s] < minSum:
        			ans = [s]
        			minSum = index + dt[s]
        		else:
        			ans.append(s)
        return ans

print Solution().findRestaurant(["Shogun", "Tapioca Express", "Burger King", "KFC"], 
	["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"])

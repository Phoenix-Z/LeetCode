import java.util.Arrays;

/**
 * (30ms)
 * 这个方法是对每一个house，在heaters中找到离house最近的两个heater(因为house可能处于两个heater之间，
 * 所有使用二分搜索时，不一定能找到与house位置一样的heater)，进一步找到离该house最近的heater，
 * 最后radius选取其中的最大值。
 * @author Phoenix-Z
 *
 */
public class Heaters2 {

	public int findRadius(int[] houses, int[] heaters) {
		//对heaters数组进行二分搜索之前，需要先排序
	    Arrays.sort(heaters);
	    int result = 0;
	    
	    for (int house : houses) {
	    	//需要注意的是，二分搜索的返回值，如果找到了，就返回那个位置的索引
	    	//如果没有找到就返回-(应该插入的位置)-1
	        int index = Arrays.binarySearch(heaters, house);
	        if (index < 0) {
	        	//取非操作等价于index = -(index + 1);
	            index = ~index;
	            int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
	            int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
	            
	            result = Math.max(result, Math.min(dist1, dist2));
	        }
	    }
	    
	    return result;
	}
	
}
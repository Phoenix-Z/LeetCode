import java.util.HashSet;
import java.util.Set;
/**
 * (8ms)
 * 这个解法挺优美的，它是使用了一个set来模拟滑动窗口的机制，如果窗口中元素满了，
 * 每次加入一个元素的同时，删除一个元素，然后通过add操作的返回值(如果set中没有该元素就加入且返回true，
 * 否则不加入该元素，并返回false)。
 * @author Phoenix-Z
 *
 */
public class ContainsDuplicateII2 {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		//这里滑动窗口的窗口大小为k+1，所以可以先声明set的大小，可以提高效率
        Set<Integer> set = new HashSet<Integer>(k + 1);
        for(int i = 0; i < nums.length; i++){
            if(i > k) 
            {
            	set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i])) 
            	return true;
        }
        return false;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 6, 3};
		System.out.println(new ContainsDuplicateII2().containsNearbyDuplicate(nums, 2));
	}
}
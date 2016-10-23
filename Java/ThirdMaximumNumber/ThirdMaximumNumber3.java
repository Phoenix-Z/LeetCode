import java.util.TreeSet;

/**
 * (23ms)
 * 这个方法很好理解，就是使用java提供的有序set，即TreeSet来实现功能。
 * 可以看到使用这个数据结构效率很低。
 * TreeSet的用处在于：保证不出现重复的元素，以及有序（从小到大）。
 * 对于set的容量小于3时，返回最后一个元素（最大值）即可。
 * 当set的容量大于3时，可以删除最后两个元素，再返回最后一个元素即可。
 * @author Phoenix-Z
 *
 */
public class ThirdMaximumNumber3 {

	public int thirdMax(int[] nums) {
		//这里应该直接声明为TreeSet类型的，以便使用TreeSet提供的特有的方法。
		TreeSet<Integer> set = new TreeSet<>();
		for(int num : nums) {
			set.add(num);
		}
		if(set.size() == 1)
			return set.last();
		//删除最后两个元素
		set.pollLast();
		set.pollLast();
		return set.last();
	}
	
	public static void main(String[] args) {
		int[] nums = {5,2,4,1,3,6,0};
		System.out.println(new ThirdMaximumNumber().thirdMax(nums));
	}
}
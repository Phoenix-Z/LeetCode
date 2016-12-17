import java.util.Arrays;
/**
 * (3ms)
 * 这个方法是在遍历数组的同时，使用二分搜索查找target减去当前遍历的值，如果找到了，返回值为目标的索引。
 * 由于重复数字的存在，二分搜索不能保证找到的是哪一个数字，比如main方法中的示例，当遍历到第一个4时，二分查找
 * 4时，可能会找到第一个4，而我们需要它找到的是第二个4。解决方法就是，由于数组已经排序，可以限定二分搜索的
 * 范围，规定只能从当前位置的下一位到数组尾进行查找，这样就可以避免找到同一位置的数字。
 * 该算法的时间复杂度为O(nlogn).
 * @author Phoenix-Z
 *
 */
public class TwoSumII2 {

	public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        for(int i = 0; i < numbers.length; i++) {
        	int pos = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);
        	if(pos > 0) {
        		index[0] = i + 1;
        		index[1] = pos + 1;
        		break;
        	}
        }
        return index;
    }
	
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 4, 9, 56, 90};
		int target = 8;
		System.out.println(Arrays.toString(new TwoSumII2().twoSum(numbers, target)));
	}
}
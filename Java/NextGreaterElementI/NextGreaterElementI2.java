import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * (10ms)
 * 这个方法显然更好一点，对于[5, 4, 3, 2, 1, 6]这个序列而言，5,4,3,2,1的next greater num都是6，
 * 可以维护一个栈，一旦遇到一个数字大于栈顶元素，那么栈顶元素的下一个更大的数字就是这个数字，存放到一个map中，
 * 同时弹出栈顶元素，以此类推。
 * @author Phoenix-Z
 *
 */
public class NextGreaterElementI2 {

	public static int[] nextGreaterElement(int[] findNums, int[] nums) {
		Map<Integer, Integer> greater = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		for(int num : nums) {
			while(!stack.isEmpty() && stack.peek() < num) {
				greater.put(stack.pop(), num);
			} 
			stack.push(num);
		}
		for(int i = 0; i < findNums.length; i++) {
			findNums[i] = greater.getOrDefault(findNums[i], -1);
		}
		return findNums;
    }
	
	public static void main(String[] args) {
		int[] findNums = {4, 1, 2};
		int[] nums = {1, 3, 4, 2};
		System.out.println(Arrays.toString(nextGreaterElement(findNums, nums)));
	}
}

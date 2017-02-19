import java.util.Arrays;
import java.util.Stack;

/**
 * (45ms) 
 * 这个方法是对第二个版本的优化，它是将数字的index添加到栈中，而不是添加值，这样就不需要额外的Map来存储中间结果。
 * 基本的思想依然是承袭Next Greater Element I的方法。
 * @author Phoenix-Z
 *
 */
public class NextGreaterElementII3 {

	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length, next[] = new int[n];
		Arrays.fill(next, -1);
		Stack<Integer> stack = new Stack<>(); // index stack
		for (int i = 0; i < n * 2; i++) {
			int num = nums[i % n];
			while (!stack.isEmpty() && nums[stack.peek()] < num)
				next[stack.pop()] = num;
			if (i < n)
				stack.push(i);
		}
		return next;
	}

}

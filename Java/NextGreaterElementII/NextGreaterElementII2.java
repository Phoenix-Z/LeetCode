import java.util.Arrays;
import java.util.Stack;
/**
 * (47ms)
 * 这个方法与Next Greater Element I的思路是一样的，借助一个栈来解决问题，不过不是push值，而是push一个内部类
 * 对象，该对象记录数字及该数字的位置。
 * @author Phoenix-Z
 *
 */
public class NextGreaterElementII2 {

	public static int[] nextGreaterElements(int[] nums) {
		class Tuple{
			int value;
			int pos;
			public Tuple(int value, int pos) {
				this.value = value;
				this.pos = pos;
			}
		}
		Stack<Tuple> stack = new Stack<>();
		int[] ans = new int[nums.length];
		Arrays.fill(ans, -1);
		for(int i = 0; i < 2 * nums.length - 1; i++) {
			while(!stack.isEmpty() && stack.peek().value < nums[i % nums.length]) {
				Tuple tuple = stack.pop();
				ans[tuple.pos] = nums[i % nums.length];
			}
			if(i < nums.length)
				stack.push(new Tuple(nums[i], i));
		}
		return ans;
    }
	
	public static void main(String[] args) {
		//int[] nums = {5, 4, 3, 2, 1};
		int[] nums = {100,1,11,1,120,111,123,1,-1,-100};
		System.out.println(Arrays.toString(nextGreaterElements(nums)));
	}
}

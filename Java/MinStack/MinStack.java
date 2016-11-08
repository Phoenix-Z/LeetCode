import java.util.Stack;

/**
 * (126ms)
 * 这个方法很机智，只是用了一个栈，但是栈里存储的元素不是所给的数字，而是先维护一个当前最小值，
 * 然后存储所给的数字与当前最小值之差，注意是当前最小值，在添加元素时，最小值是在不同更新的，
 * 所以存储的元素没有统一的标准，但是根据栈的性质，入栈时使用的最小值，一定也是出栈时使用的最小值。
 * 由于当前数字与当前最小值之差有可能会超过int型的范围(如Integer.MaxValue - Integer.MinValue),
 * 所以min和栈定义为long型。
 * @author Phoenix-Z
 *
 */
public class MinStack {

	//min是指当前最小值
	long min;
	//stack中存储的是当前数字与当前最小值之差
	Stack<Long> stack = null;

	public MinStack() {
		stack = new Stack<>();
	}

	public void push(int x) {
		//如果栈为空，当前最小值就是当前数字，差就为0，所以将0L压栈
		if (stack.isEmpty()) {
			stack.push(0L);
			min = x;
		} else {
			//当前数字与当前最小值之差可能为负值，那么当前最小值就需要更新
			stack.push(x - min);
			//更新当前最小值
			if (x < min)
				min = x;
		}
	}

	public void pop() {
		if (stack.isEmpty())
			return;

		long pop = stack.pop();

		//如果出栈的数字小于0，说明这里曾经发生过更新最小值的操作，即刚刚出栈的就是当前最小值
		//所以需要恢复更新，提高当前最小值。
		if (pop < 0)
			min = min - pop;

	}

	public int top() {
		long top = stack.peek();
		//这里和出栈的操作是一样的，如果栈顶元素小于0，就意味着这里曾经发生过更新最小值，
		//也就是说当前位置的数就是最小值，否则需要将栈顶元素(当前位置和当前最小值之差)加上最小值
		if (top > 0) {
			return (int) (top + min);
		} else {
			return (int) (min);
		}
	}

	public int getMin() {
		//这个操作就变得简单了，直接返回强转后的当前最小值即可
		return (int) min;
	}

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(-2);
		obj.push(0);
		obj.push(-1);
		System.out.println(obj.getMin());
		System.out.println(obj.top());
		obj.pop();
		System.out.println(obj.getMin());
	}
}
import java.util.Stack;

/**
 * (123ms)
 * 前两个方法都是用一个栈，而这个方法是用两个栈，基本思路与方法二是一样的。
 * 一个栈用来存储数字，另一个栈用来存储当前最小值。这个方法也很容易理解。
 * @author Phoenix-Z
 *
 */
public class MinStack3 {

	//stack栈用来存储数字
	private Stack<Integer> stack = new Stack<>();
	//min栈用来存储当前最小值，需要更新时才会压栈
	private Stack<Integer> min = new Stack<>();
 	
	public MinStack3() {
		stack = new Stack<>();
		min = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		//如果min为空栈，或者当前数字小于等于当前最小值，就压栈
		//注意是小于等于，因为可能某个最小值会出现多次
		if(min.empty() || x <= getMin())
			min.push(x);
	}

	public void pop() {
		//如果当前出栈的是当前最小值，就将其从最小值栈出栈
		if(stack.peek() == getMin())
			min.pop();
		stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min.peek();
	}
	
}
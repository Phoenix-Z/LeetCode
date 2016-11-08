import java.util.Stack;

/**
 *(104ms)
 * 这个方法更容易理解一些，它声明了一个新的内部类Element,这个Element类有两个域，一个就是当前
 * 需要入栈的数字，另一个是入栈时的最小值。那么栈就用来存储Element对象。
 * @author Phoenix-Z
 *
 */
public class MinStack2 {

	static class Element
    {
        final int value;
        final int min;
        Element(final int value, final int min)
        {
            this.value = value;
            this.min = min;
        }
    }
	//这个栈用来存储Element对象
    final Stack<Element> stack = new Stack<>();
    
    public void push(int x) {
    	//当前最小值是这样计算的：如果栈为空，那么需要入栈的元素就是最小值；
    	//如果栈非空，那么前一个入栈时的最小值和当前数字的较小值就是当前的最小值
        final int min = (stack.empty()) ? x : Math.min(stack.peek().min, x);
        
        stack.push(new Element(x, min));
    }

    public void pop()
    {
    	//这个出栈的操作很简单
        stack.pop();
    }

    public int top()
    {
    	//栈顶元素的value域就是最后一个入栈的数字
        return stack.peek().value;
    }

    public int getMin()
    {
    	//栈顶元素的min域就是最后一个数字入栈时的最小值
        return stack.peek().min;
    }
}
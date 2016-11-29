import java.util.ArrayList;
import java.util.List;

/**
 * (84ms)
 * 很简单的题目。
 * @author Phoenix-Z
 *
 */
public class ImplementStackUsingQueues {

	private List<Integer> stack = new ArrayList<>();
	
	// Push element x onto stack.
    public void push(int x) {
        stack.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        stack.remove(stack.size() - 1);
    }

    // Get the top element.
    public int top() {
        return stack.get(stack.size() - 1);
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return stack.size() == 0;
    }
	
}
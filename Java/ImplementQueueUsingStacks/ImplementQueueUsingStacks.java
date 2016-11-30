import java.util.ArrayList;
import java.util.List;

/**
 * (94ms)
 * 很简单的问题。
 * @author Phoenix-Z
 *
 */
public class ImplementQueueUsingStacks {

	private List<Integer> queue = new ArrayList<>();
	
	// Push element x to the back of queue.
    public void push(int x) {
        queue.add(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        queue.remove(0);
    }

    // Get the front element.
    public int peek() {
        return queue.get(0);
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return queue.size() == 0;
    }
	
}

import java.util.Stack;

/**
 * (9ms)
 * 这个方法就是使用一个栈来解决问题，遇到左括号就入栈，遇到右括号就查看是否与栈顶的括号匹配，
 * 如果不匹配，算法终止，否则将栈顶元素出栈。以此类推。
 * @author Phoenix-Z
 *
 */
public class ValidParentheses {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(char c : s.toCharArray()) {
			if(c == '(' || c == '[' || c== '{') {
				stack.push(c);
			} else {
				//在查看栈顶元素之前，需要判断栈是否为空，否则有可能会抛出异常
				if(stack.isEmpty())
					return false;
				//查看ASCII码表，( + 1 = ), [ + 2 = ], { + 2 = }，三种括号相离较远
				if(stack.peek() + 1 != c && stack.peek() + 2 != c)
					return false;
				stack.pop();
			}
		}
		//如果栈已空，这说明合法，否则说明有多余的左括号
		return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		String s = "(([[{}]]))";
		System.out.println(new ValidParentheses().isValid(s));
	}
}
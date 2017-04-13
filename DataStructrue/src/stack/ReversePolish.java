package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * 本程序假设输入均是合法的。
 * @author Phoenix-Z
 *
 */
public class ReversePolish {

	Map<Character, Integer> priority = new HashMap<>();
	
	{
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('(', 1);
	}
	
	public int calculate(String expression) {
		Stack<Integer> numbers = new Stack<>(); 
		Stack<Character> operator = new Stack<>();
		
		for(int i = 0; i < expression.length(); i++) {
			char now = expression.charAt(i);

			if(now == ' ')
				continue;
			
			if(now <= '9' && now >= '0') {
				int num = now - '0';
				if(i < expression.length() - 1) {
					char next = expression.charAt(++i);
					while(next <= '9' && next >= '0') {
						num = num * 10 + (next - '0');
						next = expression.charAt(++i);
					}
					i--;
				}
				numbers.push(num);
				continue;
			}
			
			if(now == '(') {
				operator.push(now);
				continue;
			}
			
			if (now == ')') {
				char op = operator.pop();
				while(op != '(') {
					numbers.push(doCal(op, numbers.pop(), numbers.pop()));
					op = operator.pop();
				}
				continue;
			}
			
			if (operator.isEmpty() || priority.get(now) >= priority.get(operator.peek())) {
				operator.push(now);
				continue;
			}
			
			while(!operator.isEmpty() && operator.peek() != '(' && priority.get(now) <= priority.get(operator.peek())) {
				numbers.push(doCal(operator.pop(), numbers.pop(), numbers.pop()));
			}
			operator.push(now);
		}
		
		// System.out.println(numbers);
		// System.out.println(operator);
		while(!operator.isEmpty()) {
			numbers.push(doCal(operator.pop(), numbers.pop(), numbers.pop()));
		}
		
		return numbers.pop();
	}
	
	public int doCal(char op, int num1, int num2) {
		int ans;
		switch (op) {
		case '+':
			ans = num1 + num2;
			break;
		case '-':
			ans = num2 - num1;
			break;
		case '*':
			ans = num1 * num2;
			break;
		case '/':
			ans = num2 / num1;
			break;
		default:
			throw new RuntimeException("illegal operator!");
		}
		return ans;
	}
	
	public static void main(String[] args) {
		ReversePolish test = new ReversePolish();
		System.out.println(test.calculate("123 + 2 * 11 + (7 * 2 + 11) * 3"));
	}
}

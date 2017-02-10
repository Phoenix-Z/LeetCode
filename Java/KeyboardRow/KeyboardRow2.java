import java.util.Arrays;
import java.util.stream.Stream;
/**
 * (101ms)
 * 这里使用的是函数式编程，使用了java8提供的新特性，效率较低。
 * @author Phoenix-Z
 *
 */
public class KeyboardRow2 {

	public static String[] findWords(String[] words) {
	    return Stream.of(words).filter(s -> s.matches("(?i)([qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*$)")).toArray(String[]::new);
	}
	
	public static void main(String[] args) {
		String[] words = {"Hello", "Alaska", "Dad", "Peace"};
		System.out.println(Arrays.toString(findWords(words)));
	}
}

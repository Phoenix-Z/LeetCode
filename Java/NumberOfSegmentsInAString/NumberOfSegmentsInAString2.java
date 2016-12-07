/**
 * (4ms)
 * 这个方法就是使用正则表达式，使用split方法将字符串分割，最后得到的字符串数组的长度就是段落数。
 * 但是需要注意的是，正则表达式应该表示一个或多个空格，以防止两个段落中有多个空白符的情况。
 * 另外在使用正则表达式split之前，需要先trim一下，否则会多出一个段落，从这可以看出java对正则表达式的实现
 * 不尽如人意，估计java的对多个空格进行分割的操作与我写的方法一的代码基本一致，我写的方法一也需要先trim。
 * 不如perl和Python中的好用。当然如果不先进行trim操作，也有另外一种机智的做法，在注释中有提及。
 * @author Phoenix-Z
 *
 */
public class NumberOfSegmentsInAString2 {

	public int countSegments(String s) {
		s = s.trim();
		return s.length() == 0 ? 0 : s.split(" +").length;
		//如下的做法本质上也是为了确保字符串开头不是空格符，多出来的段落在返回时减去即可
		//return ("x " + s).split(" +").length - 1;
	}

	public static void main(String[] args) {
		String s = "    1, 2,      3";
		System.out.println(new NumberOfSegmentsInAString2().countSegments(s));
	}
	
}
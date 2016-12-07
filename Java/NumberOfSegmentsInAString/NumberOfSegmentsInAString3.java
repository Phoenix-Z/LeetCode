import java.util.Scanner;
/**
 * (31ms)
 * 这个方法纯属娱乐，考虑到java中Scanner的next方法的特性，我把找段落的任务交给编译器自己去做，
 * 自己负责技术即可，当然这个方法的效率也是很低的。
 * @author Phoenix-Z
 *
 */
public class NumberOfSegmentsInAString3 {

	public int countSegments(String s) {
		Scanner in = new Scanner(s);
		int seg = 0;
		while(in.hasNext()) {
			in.next();
			seg++;
		}
		in.close();
		return seg;
	}
	
	public static void main(String[] args) {
		String s = "   a,   b ,c";
		System.out.println(new NumberOfSegmentsInAString3().countSegments(s));
	}
}
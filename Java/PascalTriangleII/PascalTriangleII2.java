import java.util.ArrayList;
import java.util.List;
/**
 * (2ms)
 * 这个写法很优美，代码很少，学习一下。
 * @author Phoenix-Z
 *
 */
public class PascalTriangleII2 {

	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		if (rowIndex < 0)
			return list;

		for (int i = 0; i < rowIndex + 1; i++) {
			list.add(0, 1);
			for (int j = 1; j < list.size() - 1; j++) {
				list.set(j, list.get(j) + list.get(j + 1));
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 3};
		PascalTriangleII2 test = new PascalTriangleII2();
		for(int num : nums)
		{
			System.out.println(test.getRow(num));
		}
	}
}
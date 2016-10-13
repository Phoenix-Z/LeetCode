import java.util.ArrayList;
import java.util.List;
/**
 * (1ms)
 * 使用两个数组，交替存储pascal三角的数据，最后再添加到list中。
 * @author Phoenix-Z
 *
 */
public class PascalTriangleII {

	public List<Integer> getRow(int rowIndex) {
		int[] ans1 = new int[rowIndex + 1];
		int[] ans2 = new int[rowIndex + 1];
		ans1[0] = 1;
		List<Integer> ans = new ArrayList<>();
		for(int i = 1; i <= rowIndex; i++)
		{
			if(i % 2 == 0)
			{
				for(int j = 0; j <= i; j++)
				{
					if(j == 0 || j == i)
					{
						ans1[j] = 1;
					} else {
						ans1[j] = ans2[j - 1] + ans2[j];
					}
				}
			} else {
				for(int j = 0; j <= i; j++)
				{
					if(j == 0 || j == i)
					{
						ans2[j] = 1;
					} else {
						ans2[j] = ans1[j - 1] + ans1[j];
					}
				}
			}
		}
		int[] ansArr = rowIndex % 2 == 0 ? ans1 : ans2;
		for(int num : ansArr)
		{
			ans.add(num);
		}
		return ans;
    }
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 3};
		PascalTriangleII test = new PascalTriangleII();
		for(int num : nums)
		{
			System.out.println(test.getRow(num));
		}
	}
}
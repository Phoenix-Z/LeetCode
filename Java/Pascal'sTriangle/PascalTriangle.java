import java.util.ArrayList;
import java.util.List;

/**
 * (1ms)
 * 杨辉三角，需要注意的是不能将二维数组直接转化为list，需要一个个的添加。
 * @author Phoenix-Z
 *
 */
public class PascalTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> pascal = new ArrayList<>(numRows);
		
		int[][] nums = new int[numRows][];
		for(int i = 0; i < numRows; i++)
		{
			nums[i] = new int[i + 1];
			List<Integer> now = new ArrayList<>();
			
			nums[i][0] = 1;
			now.add(nums[i][0]);
			for(int j = 1; j < i + 1; j++)
			{
				if(j < i)
					nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
				else
					nums[i][j] = 1;
				now.add(nums[i][j]);
			}
			pascal.add(now);
		}
		return pascal;
    }
	
}
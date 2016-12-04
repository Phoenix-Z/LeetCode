import java.util.HashMap;
import java.util.Map;
/**
 * (271ms)
 * 这道题目我采用的做法是，首先计算任意两点间的距离，并用一个二维数组存储下来。然后在对每一行遍历，
 * 这相当于将这一行对应的点作为tuple的第一个点，然后使用一个map来存储每一个distance出现的次数，
 * 如果出现的次数大于等于2，就可以构成一个tuple，假如某一个distance出现的次数是count的话，那么
 * 可以构成的tuple个数为C(count, 2) * 2(注意次序是区分的)。时间复杂度和空间复杂度均为O(n ^ 2)。
 * @author Phoenix-Z
 *
 */
public class NumberOfBoomerangs {

	public int numberOfBoomerangs(int[][] points) {
		int num = 0;
		int[][] distance = new int[points.length][];
		for(int i = 0; i < points.length; i++) {
			distance[i] = new int[points.length];
		}
		//计算任意两点的距离
		for(int i = 0; i < points.length; i++) {
			for(int j = 0; j < points.length; j++) {
				distance[i][j] = (int)(Math.pow(points[i][0] - points[j][0], 2)
						+ Math.pow(points[i][1] - points[j][1], 2));
			}
		}
		
		for(int i = 0; i < points.length; i++) {
			Map<Integer, Integer> map = new HashMap<>();
			//统计这一行中各个距离出现的次数
			for(int j = 0; j < points.length; j++) {
				int count = map.getOrDefault(distance[i][j], 0) + 1;
				map.put(distance[i][j], count);
			}
			//计算可行的tuple的个数
			for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
				int count = entry.getValue();
				if(count >= 2) {
					num += count * (count - 1);
				}
			}
		}
		return num;
    }
	
	public static void main(String[] args) {
		int[][] points = {{0,0},{1,0},{2,0}};
		System.out.println(new NumberOfBoomerangs().numberOfBoomerangs(points));
	}
}
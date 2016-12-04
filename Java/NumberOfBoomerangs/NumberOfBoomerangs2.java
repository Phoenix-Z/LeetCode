import java.util.HashMap;
import java.util.Map;

/**
 * (156ms)
 * 这个方法的思路与方法一的基本是一致的，只不过这里没有存储下任意两点之间的距离，而是直接将出现的次数
 * 添加到map当中，节省空间的同时，还能把效率提高这么多，这是一开始我没有想到的。
 * @author Phoenix-Z
 *
 */
public class NumberOfBoomerangs2 {

	public int numberOfBoomerangs(int[][] points) {
		int res = 0;

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				if (i == j)
					continue;

				int d = getDistance(points[i], points[j]);
				map.put(d, map.getOrDefault(d, 0) + 1);
			}

			//这里我们只关心值，而不关心键，所以之间获取值对应的集合即可
			for (int val : map.values()) {
				res += val * (val - 1);
			}
			map.clear();
		}

		return res;
	}

	//计算两点间的距离
	private int getDistance(int[] a, int[] b) {
		int dx = a[0] - b[0];
		int dy = a[1] - b[1];

		return dx * dx + dy * dy;
	}

}


import java.util.Arrays;
import java.util.Comparator;
/**
 * (40ms)
 * 这是一个贪心算法，需要先对原始数组排序，
 * @author Phoenix-Z
 *
 */
public class MinimumNumberOfArrowsToBurstBalloons {

	public static int findMinArrowShots(int[][] points) {
		if(points == null || points.length == 0) {
            return 0;
        }
		Arrays.sort(points, new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				return arg0[0] - arg1[0];
			}
		});
		// System.out.println(Arrays.deepToString(points));
		int arrows = 1;
		int now = points[0][1];
		for(int i = 1; i < points.length; i++) {
			now = Math.min(now, points[i][1]);
			if(now >= points[i][0]) {
				continue;
			}
			arrows++;
			now = points[i][1];
		}
		return arrows;
    }
	
	public static void main(String[] args) {
		//int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
		//int[][] points = {{1,2}, {3, 4}, {5,6}, {7,8}};
		int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
		//int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
		System.out.println(findMinArrowShots(points));
	}
}

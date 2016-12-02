/**
 * (146ms) 
 * 这个版本是对方法一的优化，可以看到空间复杂度从O(m * n)变成了O(1),基本思路是一样，不过与方法一不同的是，
 * 这个方法没有对每一个岛屿统计邻居数，而是放到了一起统计，用neighbor变量来表示。统计时采用的也是只统计了
 * 右边和下边的邻居，所以最后的结果需要乘2。
 * @author Phoenix-Z
 *
 */
public class IslandPerimeter2 {

	public int islandPerimeter(int[][] grid) {
		int islands = 0, neighbours = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					islands++; 				// count islands
					if (i < grid.length - 1 && grid[i + 1][j] == 1)
						neighbours++; 		// count down neighbours
					if (j < grid[i].length - 1 && grid[i][j + 1] == 1)
						neighbours++; 		// count right neighbours
				}
			}
		}

		return islands * 4 - neighbours * 2;
	}

}
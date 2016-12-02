/**
 * (126ms)
 * 这道题目主要就是看每一个小方块是否是岛屿(值为1),以及它有几个相邻岛屿。最普通的做法是先判断其是否为岛屿，
 * 然后看它的上下左右是否是岛屿，从而它最后贡献的边数应该等于4减去相邻岛屿的个数。
 * 我在这个方法做了一点优化，只查看该岛屿的右边和下边的小格是否是岛屿，比如说，如果该岛屿右边有岛屿，
 * 那就意味着右边的岛屿左边是有岛屿的，同理可以理解只考察下边的小格。所以在后边处理时，只需要查看一半的
 * 小格即可，不需要回头看。当然这个版本浪费了相对较多的空间。
 * @author Phoenix-Z
 *
 */
public class IslandPerimeter {

	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		int[][] countOfOne = new int[grid.length][];
		for(int i = 0; i < grid.length; i++)
		{
			countOfOne[i] = new int[grid[i].length];
		}
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++)
			{
				if(grid[i][j] == 1)
				{
					countOfOne[i][j]++;
					if(i < grid.length - 1 && grid[i + 1][j] == 1)
					{
						countOfOne[i][j]++;
						countOfOne[i + 1][j]++;
					}
					if(j < grid[i].length - 1 && grid[i][j + 1] == 1)
					{
						countOfOne[i][j]++;
						countOfOne[i][j + 1]++;
					}
				}
				if(countOfOne[i][j] > 0)
				{
					perimeter += 4 - countOfOne[i][j] + 1;
				}
			}
		}
		
		return perimeter;
    }
	
	public static void main(String[] args) {
		int[][] grid = {{0,1,0,0},
		                {1,1,1,0},
		                {0,1,0,0},
		                {1,1,0,0}};
		System.out.println(new IslandPerimeter().islandPerimeter(grid));
	}
}
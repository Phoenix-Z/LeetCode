import java.util.HashSet;

/**
 * (33ms)
 * 这个版本就是方法一的简化版本，这个把之前分开的三个循环集合到一个循环中，至于小九宫格的处理是通过整除和取余
 * 来实现的。但是很奇怪的是，运行效率居然和之前的版本差不多，甚至还不如之前那个版本的效率高。
 * @author Phoenix-Z
 *
 */
public class ValidSudoku2 {

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Character> rows = new HashSet<Character>();
			HashSet<Character> columns = new HashSet<Character>();
			HashSet<Character> cube = new HashSet<Character>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !rows.add(board[i][j]))
					return false;
				if (board[j][i] != '.' && !columns.add(board[j][i]))
					return false;
				int RowIndex = 3 * (i / 3);
				int ColIndex = 3 * (i % 3);
				if (board[RowIndex + j / 3][ColIndex + j % 3] != '.'
						&& !cube.add(board[RowIndex + j / 3][ColIndex + j % 3]))
					return false;
			}
		}
		return true;
	}

}
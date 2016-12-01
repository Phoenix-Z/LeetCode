import java.util.HashSet;
import java.util.Set;

/**
 * (36ms)
 * 这个方法也是很有想法的，它在遍历的时候，不仅仅记录下出现的数字，还记录了这个数字出现在第几行，第几列，
 * 在哪一个子块里，充分利用这些信息，整合到字符串中，所有set中存放的是字符串而不是字符。虽然这个方法很精妙，
 * 也很容易理解。但是，时间复杂度依然为O(n^2)，而且由于存储许多其他的信息，所以占用的空间也较多。
 * @author Phoenix-Z
 *
 */
public class ValidSudoku3 {

	public boolean isValidSudoku(char[][] board) {
		Set<String> seen = new HashSet<>();
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				char number = board[i][j];
				if (number != '.')
					if (!seen.add(number + " in row " + i) || !seen.add(number + " in column " + j)
							|| !seen.add(number + " in block " + i / 3 + "-" + j / 3))
						return false;
			}
		}
		return true;
	}

}
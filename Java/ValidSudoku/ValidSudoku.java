import java.util.HashSet;
import java.util.Set;

/**
 * (31ms)
 * 这个方法就是针对数独的三条规则分别进行判断，唯一使用的数据结构是Set，如果一个数字已经存在于set中，
 * 那么在执行add操作时会返回false。
 * @author Phoenix-Z
 *
 */
public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		//Rule 1 : Each row must have the numbers 1-9 occuring just once
		for(int i = 0; i < board.length; i++)
		{
			Set<Character> num = new HashSet<>();
			for(int j = 0; j < board[0].length; j++)
			{
				if(board[i][j] != '.' && !num.add(board[i][j]))
					return false;
			}
		}
		
		//Rule 2 : Each column must have the numbers 1-9 occuring just once
		for(int i = 0; i < board[0].length; i++)
		{
			Set<Character> num = new HashSet<>();
			for(int j = 0; j < board.length; j++)
			{
				if(board[j][i] != '.' && !num.add(board[j][i]))
					return false;
			}
		}
		
		//Rule 3 : the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid
		for(int i = 0; i < board.length; i += 3)
		{
			for(int j = 0; j < board[0].length; j += 3)
			{
				Set<Character> num = new HashSet<>();
				for(int k = i; k < i + 3; k++)
				{
					for(int r = j; r < j + 3; r++)
					{
						if(board[k][r] != '.' && !num.add(board[k][r]))
							return false;
					}
				}
			}
		}
		return true;
    }
	
	public static void main(String[] args) {
		String[] s = {"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",
				".2.9.....","..4......"};
		char[][] board = new char[s.length][];
		for(int i = 0; i < s.length; i++)
		{
			board[i] = s[i].toCharArray();
		}
/*		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board[0].length; j++)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}*/
		System.out.println(new ValidSudoku().isValidSudoku(board));
	}
}
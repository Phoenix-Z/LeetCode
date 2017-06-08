import java.util.Arrays;

/**
 * Created by Phoenix-Z on 2017/6/7.
 */
public class Minesweeper {

    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        int mines = checkMines(board, click);
        if(mines == 0) {
            board[click[0]][click[1]] = 'B';
            DFS(board, click[0], click[1], visited);
        } else {
            board[click[0]][click[1]] = (char) (mines + '0');
        }
        return board;
    }

    private void DFS(char[][] board, int row, int col, boolean[][] visited) {
        int mines = checkMines(board, new int[]{row, col});
        if(mines == 0) {
            board[row][col] = 'B';
            for(int i = row - 1; i <= row + 1; i++) {
                for(int j = col - 1; j <= col + 1; j++) {
                    if(i >= 0 && i < board.length && j >= 0 && j < board[i].length && !visited[i][j]) {
                        visited[i][j] = true;
                        DFS(board, i, j, visited);
                    }
                }
            }
        } else {
            board[row][col] = (char) (mines + '0');
        }
    }

    private int checkMines(char[][] board, int[] click) {
        int count = 0;
        for(int i = click[0] - 1; i <= click[0] + 1; i++) {
            for(int j = click[1] - 1; j <= click[1] + 1; j++) {
                if(i >= 0 && i < board.length && j >= 0 && j < board[i].length) {
                    if(board[i][j] == 'M')
                        count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'},
                         {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        Minesweeper test = new Minesweeper();
        System.out.println(Arrays.deepToString(test.updateBoard(board, new int[]{3, 0})));
    }

}

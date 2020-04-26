import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法解N皇后问题
 * Created by goto456 on 2020/4/26.
 */
public class _0051_NQueens {
    public List<List<String>> result = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        // 二维char数组表示棋盘
        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars, '.');
        }
        backtrack(board, 0);
        return result;
    }

    public void backtrack(char[][] board, int row) {
        if (row == board.length) {
            result.add(charToString(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            // 剪枝，当前位置是否合法
            if (!isValid(board, row, col)) {
                continue;
            }

            board[row][col] = 'Q';
            backtrack(board, row + 1);
            board[row][col] = '.';
        }
    }

    private List<String> charToString(char[][] charsArray) {
        List<String> result = new LinkedList<>();
        for (char[] chars : charsArray) {
            result.add(String.valueOf(chars));
        }
        return result;
    }

    private boolean isValid(char[][] board, int row, int col) {
        // 检查当前列是否合法
        for (char[] rows : board) {
            if (rows[col] == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查右上方是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}

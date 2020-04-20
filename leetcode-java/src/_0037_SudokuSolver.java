/**
 * 回溯法解数独
 * Created by goto456 on 2020/04/01.
 */
public class _0037_SudokuSolver {
    public static void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    public static boolean backtrack(char[][] board, int i, int j) {
        int m = 9;
        int n = 9;

        // 横向已经到达最后一列，开始从下一行开始
        if (j == n) {
            return backtrack(board, i + 1, 0);
        }

        // 纵向也到达了最后一行，表示递归结束，找到一个解
        if (i == m) {
            return true;
        }

        // 不需要填数字
        if (board[i][j] != '.') {
            return backtrack(board, i, j + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            // 当前数字放在此处不合法，直接跳过
            if (!isValid(board, i, j, ch)) {
                continue;
            }
            board[i][j] = ch;
            // 如果找到一个解，则结束
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }
        return false;
    }

    /**
     * 判断该数字填在此处是否合法
     */
    public static boolean isValid(char[][] board, int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            // 当前行已存在
            if (board[r][i] == ch) {
                return false;
            }
            // 当前列已存在
            if (board[i][c] == ch) {
                return false;
            }
            // 当前 3 x 3 小区域内已存在
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == ch) {
                return false;
            }
        }
        return true;
    }
}

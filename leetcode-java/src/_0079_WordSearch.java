/**
 * 回溯法解单词搜索
 * Created by goto456 on 2020/5/1.
 */
public class _0079_WordSearch {
    private boolean[][] marked;
    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }

        m = board.length;
        n = board[0].length;
        marked = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (backtrack(board, word, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int row, int col, int start) {
        if (start == word.length() - 1) {
            return board[row][col] == word.charAt(start);
        }

        if (board[row][col] == word.charAt(start)) {
            marked[row][col] = true;
            for (int i = 0; i < 4; i++) {
                // 控制下一步往哪走
                int nextRow = row + direction[i][0];
                int nextCol = col + direction[i][1];
                // 下一个位置不合法
                if (!isValidDirection(nextRow, nextCol, m, n)) {
                    continue;
                }
                // 下一个位置已经走过了
                if (marked[nextRow][nextCol]) {
                    continue;
                }
                if (backtrack(board, word, nextRow, nextCol, start + 1)) {
                    return true;
                }
            }
            marked[row][col] = false;
        }
        return false;
    }

    /**
     * 判断当前前进的方向是否超出了合法范围
     */
    public boolean isValidDirection(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}

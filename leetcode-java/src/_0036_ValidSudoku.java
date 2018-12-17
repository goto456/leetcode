import java.util.HashSet;
import java.util.Set;

/**
 * Created by goto456 on 2018/12/16.
 */
public class _0036_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> digitsSet = new HashSet<>();
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                char ch = board[i][j];
                String rowCheckKey = ch + " in row " + i;
                String colCheckKey = ch + " in col " + j;
                String subBoxCheckKey = ch + " in sub box " + i / 3 + "-" + j / 3;
                if (!digitsSet.add(rowCheckKey) || !digitsSet.add(colCheckKey) || !digitsSet.add(subBoxCheckKey)) {
                    return false;
                }
            }
        }
        return true;
    }
}

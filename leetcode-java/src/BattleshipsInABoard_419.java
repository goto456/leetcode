/**
 * FileName: BattleshipsInABoard_419.java
 * Description: 因为给的数据保证是有效的，所以只需要计算每个X上方和左方是否有相邻的X，如果没有则战舰数目加1
 * Authors: wangbiwen
 * Date: 17-1-17
 */
public class BattleshipsInABoard_419 {
    public int countBattleships(char[][] board) {
        int rowNum = board.length;
        int colNum = board[0].length;
        int count = 0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (i > 0 && board[i - 1][j] == 'X') {
                    continue;
                }
                if (j > 0 && board[i][j - 1] == 'X') {
                    continue;
                }
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        BattleshipsInABoard_419 battlesCounter = new BattleshipsInABoard_419();
        char[][] board = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', 'X', '.', '.'},
                {'X', '.', '.', 'X'}};
        int count = battlesCounter.countBattleships(board);
        System.out.println(count);
    }
}

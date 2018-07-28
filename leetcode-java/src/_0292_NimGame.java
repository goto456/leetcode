/**
 * FileName: NimGame_292.java
 * Description: 若保证我能稳赢，则必须使得我拨完后还剩4的倍数，这样对方无论拨走多少个（因为只能拨走1~3个），最后肯定是我拨完。
 * Authors: wangbiwen
 * Date: 17-2-4
 */
public class _0292_NimGame {
    public boolean canWinNim(int n) {
        if (n % 4 == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _0292_NimGame nimGame = new _0292_NimGame();
        int n = 4;
        boolean result = nimGame.canWinNim(n);
        System.out.println(result);
    }
}

/**
 * Created by goto456 on 2020/7/9.
 */
public class _0066_PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            // 进行加1操作
            digits[i]++;
            digits[i] = digits[i] % 10;
            // 表示加完1没进位，直接返回数据
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 表示每位都产生了进位
        digits = new int[digits.length + 1];
        // 只需要首位为1，后面都为0
        digits[0] = 1;
        return digits;
    }
}

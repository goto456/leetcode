/**
 * FileName: CountingBits_338.java
 * Description: 递推原理是能被2整除的数，其二进制最后一位一定是0，所以将其右移一位后1的个数不变；不能被2整除的数，右移一位后1的个数减一。
 * Authors: wangbiwen
 * Date: 17-1-19
 */
public class _0338_CountingBits {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                result[i] = result[i >> 1];
            } else {
                result[i] = result[i >> 1] + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _0338_CountingBits counter = new _0338_CountingBits();
        int num = 5;
        int[] result = counter.countBits(num);
        for (int i = 0; i < result.length; i++)
        System.out.println(result[i]);
    }
}

/**
 * FileName: CountingBits_338.java
 * Description: 递推原理是能被2整除的数，其二进制最后一位一定是0，所以将其右移一位后1的个数不变；不能被2整除的数，右移一位后1的个数减一。
 * Authors: wangbiwen
 * Date: 17-1-19
 */
public class CountingBits_338 {
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
        CountingBits_338 counter = new CountingBits_338();
        int num = 5;
        int[] result = counter.countBits(num);
        for (int i = 0; i < result.length; i++)
        System.out.println(result[i]);
    }
}

/**
 * FileName: NumberComplement_476.java
 * Description: 用相同位数的全是1的二进制数和它进行异或运算就得到所求结果
 * Authors: wangbiwen
 * Date: 17-1-20
 */
public class _0476_NumberComplement {
    public int findComplement(int num) {
        int mask = 1;
        int temp = num;
        while (temp > 0) {
            mask = mask << 1;
            temp = temp >> 1;
        }
        return num ^ (mask - 1);
    }

    public static void main(String[] args) {
        _0476_NumberComplement nc = new _0476_NumberComplement();
        int num = 5;
        int result = nc.findComplement(num);
        System.out.println(result);
    }
}

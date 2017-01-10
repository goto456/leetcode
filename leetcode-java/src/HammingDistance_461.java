/**
 * FileName: HammingDistance_461.java
 * Description:求海明距离（即求二进制不同位的个数），先将2个数进行异或运算，然后求结果的海明重量（即二进制1的个数）
 * Authors: wangbiwen
 * Date: 17-1-10
 */
public class HammingDistance_461 {
    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int count = 0;
        while (z > 0) {
            z = z & (z - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        HammingDistance_461 hmd = new HammingDistance_461();
        int x = 1;
        int y = 4;
        int distance = hmd.hammingDistance(x, y);
        System.out.println(distance);
    }
}

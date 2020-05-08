/**
 * Created by goto456 on 2020/5/7.
 */
public class _0096_UniqueBinarySearchTrees {
    /**
     * 卡特兰数解此问题
     */
    public int numTrees(int n) {
        // 注意是从0到n
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                res[i] += res[j - 1] * res[i - j];
            }
        }
        return res[n];
    }

    /**
     * 该解法超时了
     */
    public int numTrees2(int n) {
        if (n == 0) {
            return 0;
        }
        return numChildTrees(1, n);
    }

    private int numChildTrees(int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            int leftTreesNum = numChildTrees(start, i - 1);
            int rightTreeNum = numChildTrees(i + 1, end);
            if (leftTreesNum == 0) {
                num += rightTreeNum;
            } else if (rightTreeNum == 0) {
                num += leftTreesNum;
            } else {
                num += leftTreesNum * rightTreeNum;
            }
        }
        return num;
    }
}

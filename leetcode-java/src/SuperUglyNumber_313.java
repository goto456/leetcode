/**
 * Created by wangbiwen on 2017/5/31.
 */
public class SuperUglyNumber_313 {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] superUglyNumber = new int[n];
        int[] indexes = new int[k];
        int[] values = new int[k];
        superUglyNumber[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                values[j] = primes[j] * superUglyNumber[indexes[j]];
            }
            int minVlaue = values[0];
            int minIndex = 0;
            for (int j = 0; j < k; j++) {
                if (values[j] < minVlaue && values[j] > superUglyNumber[i - 1]) {
                    minVlaue = values[j];
                    minIndex = j;
                }
            }
            superUglyNumber[i] = minVlaue;
            indexes[minIndex]++;
        }


        for (int item : superUglyNumber) {
            System.out.println(item);
        }
        return superUglyNumber[n - 1];
    }

    public static void main(String[] args) {
//        int n = 12;
//        int[] primes = {2, 7, 13, 19};
        int n = 15;
        int[] primes = {3,5,7,11,19,23,29,41,43,47};
        nthSuperUglyNumber(n, primes);
    }
}

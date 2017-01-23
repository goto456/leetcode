import java.util.ArrayList;
import java.util.List;

/**
 * FileName: FizzBuzz_412.java
 * Description: 思路很简单，见代码
 * Authors: wangbiwen
 * Date: 17-1-22
 */
public class FizzBuzz_412 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FizzBuzz_412 fizzBuzz = new FizzBuzz_412();
        int n = 15;
        List<String> result = fizzBuzz.fizzBuzz(n);
        System.out.println(result);
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: FizzBuzz_412.java
 * Description: 思路很简单，见代码
 * Authors: wangbiwen
 * Date: 17-1-22
 */
public class _0412_FizzBuzz {
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
        _0412_FizzBuzz fizzBuzz = new _0412_FizzBuzz();
        int n = 15;
        List<String> result = fizzBuzz.fizzBuzz(n);
        System.out.println(result);
    }
}

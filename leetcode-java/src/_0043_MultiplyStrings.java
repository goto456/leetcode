/**
 * Created by goto456 on 2020/5/26.
 */
public class _0043_MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String result = "0";
        // 记录补0的个数
        int zeroCount = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            int carry = 0;

            // 补0
            for (int j = 0; j < zeroCount; j++) {
                sb.append("0");
            }

            int x = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int y = num1.charAt(j) - '0';
                int product = (x * y + carry) % 10;
                carry = (x * y + carry) / 10;
                sb.append(product);
            }
            // 别忘了还有进位
            if (carry > 0) {
                sb.append(carry);
            }
            result = addStrings(result, sb.reverse().toString());
            // 补0数加1
            zeroCount++;
        }
        return result;
    }

    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            int x = num1.charAt(i) - '0';
            int y = num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            sb.append(sum);
            i--;
            j--;
        }
        while (i >= 0) {
            int x = num1.charAt(i) - '0';
            int sum = (x + carry) % 10;
            carry = (x + carry) / 10;
            sb.append(sum);
            i--;
        }
        while (j >= 0) {
            int y = num1.charAt(j) - '0';
            int sum = (y + carry) % 10;
            carry = (y + carry) / 10;
            sb.append(sum);
            j--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}

/**
 * Created by goto456 on 2020/5/26.
 */
public class _0415_AddStrings {
    public String addStrings(String num1, String num2) {
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
            int y = num2.charAt(j) - '0';
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

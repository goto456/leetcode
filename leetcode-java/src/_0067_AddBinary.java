/**
 * Created by goto456 on 2020/5/28.
 */
public class _0067_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 && j >= 0) {
            int x = a.charAt(i) - '0';
            int y = b.charAt(j) - '0';
            int sum = (x + y + carry) % 2;
            carry = (x + y + carry) / 2;
            sb.append(sum);
            i--;
            j--;
        }
        while (i >= 0) {
            int x = a.charAt(i) - '0';
            int sum = (x + carry) % 2;
            carry = (x + carry) / 2;
            sb.append(sum);
            i--;
        }
        while (j >= 0) {
            int y = b.charAt(j) - '0';
            int sum = (y + carry) % 2;
            carry = (y + carry) / 2;
            sb.append(sum);
            j--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}

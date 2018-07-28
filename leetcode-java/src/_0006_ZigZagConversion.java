import java.util.ArrayList;
import java.util.List;

/**
 * Created by goto456 on 28/07/2018.
 *
 */
public class _0006_ZigZagConversion {

    public static String convert1(String s, int numRows) {
        if (s.length() == 1 || numRows < 2) {
            return s;
        }

        // 用来存储每行的结果
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        // 当前所在的行
        int curRow = 0;
        // 是否是向下行走
        boolean goingDown = true;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (goingDown) {
                curRow += 1;
            } else {
                curRow -= 1;
            }
            // 每次行走到最下一行或者最上一行，则改变行走方向
            if (curRow == numRows - 1 || curRow == 0) {
                goingDown = !goingDown;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    public static String convert2(String s, int numRows) {
        if (s.length() == 1 || numRows < 2) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int len = s.length();
        // 一个循环周期的长度
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i ++) {
            for (int j = i; j < len; j += cycleLen) {
                result.append(s.charAt(j));
                // 如果不是首行和末行，则还需要多加一个
                if (i > 0 && i < numRows - 1) {
                    int k = j + cycleLen - 2 * i;
                    if (k < len) {
                        result.append(s.charAt(k));
                    }
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = convert2(s, numRows);
        System.out.println(result);
        System.out.println(result.equals("PAHNAPLSIIGYIR"));

        numRows = 4;
        result = convert2(s, numRows);
        System.out.println(result);
        System.out.println(result.equals("PINALSIGYAHRPI"));

    }
}

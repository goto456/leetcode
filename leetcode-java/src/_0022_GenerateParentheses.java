import java.util.*;

/**
 * Created by goto456 on 2018/11/22.
 */
public class _0022_GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return Arrays.asList("");
        }

        // Set 用于结果去重
        Set<String> resultSet = new HashSet<>();
        List<String> less = generateParenthesis(n - 1);
        for (String item : less) {
            for (int i = 0; i < item.length(); i++) {
                if (item.charAt(i) == '(') {
                    resultSet.add(item.substring(0, i + 1) + "()" + item.substring(i + 1));
                }
            }
            resultSet.add("()" + item);
        }

        List<String> result = new ArrayList<>();
        result.addAll(resultSet);
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}

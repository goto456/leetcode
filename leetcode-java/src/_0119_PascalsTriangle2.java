import java.util.ArrayList;
import java.util.List;

/**
 * Created by goto456 on 2020/7/21.
 */
public class _0119_PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        // 利用前一行求后一行
        for (int i = 0; i <= rowIndex; i++) {
            // 行末尾为1
            list.add(1);
            // 每一行更新过程，从倒数第二个往前更新
            for (int j = list.size() - 2; j > 0; j--) {
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }
}

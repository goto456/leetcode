import java.util.ArrayList;
import java.util.List;

/**
 * Created by goto456 on 2020/7/11.
 */
public class _0118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int row = 1; row < numRows; row++) {
            List<Integer> curRow = new ArrayList<>();
            List<Integer> preRow = triangle.get(row - 1);
            curRow.add(1);

            for (int j = 1; j < row; j++) {
                curRow.add(preRow.get(j - 1) + preRow.get(j));
            }

            curRow.add(1);
            triangle.add(curRow);
        }

        return triangle;
    }
}

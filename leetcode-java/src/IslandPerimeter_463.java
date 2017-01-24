/**
 * FileName: IslandPerimeter_463.java
 * Description: 从左上向右下遍历二维数组，如果方格为1，则周长+4，如果方格有一条边与其他为1的方格重合，则周长-2.
 * Authors: wangbiwen
 * Date: 17-1-24
 */
public class IslandPerimeter_463 {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        perimeter -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        perimeter -= 2;
                    }
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        IslandPerimeter_463 island = new IslandPerimeter_463();
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}};
        int result = island.islandPerimeter(grid);
        System.out.println(result);
    }
}

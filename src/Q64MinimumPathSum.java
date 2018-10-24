/**
 * @author ahscuml
 * @date 2018/10/24
 * @time 9:36
 */
public class Q64MinimumPathSum {
    public static void main(String[] args) {
        int[][] nums = {{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        System.out.println(minPathSum(nums));
    }

    public static int minPathSum(int[][] grid) {
        return shortPath(grid, grid.length - 1, grid[0].length - 1);
    }

    private static int shortPath(int[][] grid, int m, int n) {
        if (m < 1 && n < 1) {
            return grid[0][0];
        } else if (m < 1 && n >= 1) {
            return shortPath(grid, m, n - 1) + grid[m][n];
        } else if (m >= 1 && n < 1) {
            return shortPath(grid, m - 1, n) + grid[m][n];
        } else {
            return Math.min(shortPath(grid, m - 1, n), shortPath(grid, m, n - 1)) + grid[m][n];
        }
    }
}

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ahscuml
 * @date 2019/1/3
 * @time 15:04
 */
//TODO unionfind方法
public class Q200NumberofIslands {
    /**
     * 测试函数
     * */
    public static void main(String[] args) {
        char[][] islands = {{'1','1','1','1','0'},{'1','1','0','1','0'} ,{'1','1','0','0','0'} ,{'0','0','0','0','0'}};

        System.out.println(numIslandsbfs(islands));
        System.out.println(numislandsdfs(islands));
    }

    /**
     * BFS方法，时间慢一点，但是不会产生栈溢出
     * */
    public static int numIslandsbfs(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int ans = 0;
        boolean[][] v = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !v[i][j]) {
                    ans++;
                    bfs(grid, v, i, j);
                }
            }
        }
        return ans;
    }

    private static void bfs(char[][] grid, boolean[][] v, int sx, int sy) {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        qx.offer(sx);
        qy.offer(sy);
        v[sx][sy] = true;

        while (!qx.isEmpty()) {
            int cx = qx.poll();
            int cy = qy.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length && !v[nx][ny] && grid[nx][ny] == '1') {
                    qx.offer(nx);
                    qy.offer(ny);
                    v[nx][ny] = true;
                }
            }
        }
    }

    private static int m;
    private static int n;
    /**
     * DFS方法，可能会产生栈的溢出
     * */
    public static int numislandsdfs(char[][] grid) {
        // 行数
        n = grid.length;
        if (n == 0)
            return 0;
        // 列数
        m = grid[0].length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int i, int j) {
        if(i >=0 && j>=0 && i< n && j< m && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);

        }
    }
}

/**
 * @author ahscuml
 * @date 2018/10/24
 * @time 20:54
 */
public class Q62UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }

    /**
     * 动态规划，想法是正确的，但是TLE
     * */
    /*public static int uniquePaths(int m, int n) {
        // 如果到一边，则没有路了，结束计算
        return unique(m,n,0,0);
    }
    private static int unique(int m, int n, int i, int j) {
        int count = 0;
        if(i == m - 1 || j == n - 1) {
            return 1;
        } else {
            count = unique(m,n,i+1,j) + unique(m,n,i,j+1);
        }
        return count;
    }*/

    /**
     * 动态规划的优化，利用空间换时间，将之前计算过的结果存储起来
     * */
    /*public static int uniquePaths(int m, int n) {
        int[][] aux = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) {
                    aux[i][j] = 1;
                }
                else {
                    aux[i][j] = aux[i - 1][j] + aux[i][j - 1];
                }
            }
        }
        return aux[m-1][n-1];
    }*/

    /**
     * 动态规划，但是使用更少的空间，因为aux[i][j]依赖上面与左边的两个元素，所以不用存储所有的元素
     * 只用存储上面一行和左边的一个，左边的一个还可以存储到上面一行中替代之前的元素，这样只用存储一行的元素
     */
    public static int uniquePaths(int m, int n) {
        // 使用最少的空间,保证列最小(后面的最小)
        if (m < n) {
            return uniquePaths(n, m);
        }
        int[] aux = new int[n];
        // 数组没有初始化的默认是1
        aux[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j > 0) {
                    aux[j] = aux[j - 1] + aux[j];
                }
            }
        }
        return aux[n - 1];
    }
}

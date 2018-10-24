/**
 * @author ahscuml
 * @date 2018/10/24
 * @time 20:17
 */
public class Q48RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 顺时针旋转90度
     * 总共有两种方法，代表了两种思路,但应用的是同一规律
     * 变化规律 (i,j) > (j,n - 1 - i)
     */
    public static void rotate(int[][] matrix) {

        // 将上面的规律分成两步进行 首先进行沿中轴线对称(i,j) > (n - 1 - i, j)，其次沿对角线对称(n - 1 - i, j) > (j, n - 1 - i);
        // 首先进行第一步
        int n = matrix.length;
        // 水平对称 i是行，j 是列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
        // 斜向对称(注意上面是水平还是垂直对称，不同的对称方式，斜向对称的方向不一样)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        }
    }


    /*public static void rotate(int[][] matrix) {
        // 这种方法比上一种方法更加迅速，因为上一个方法每一个元素交换了两次才交换完成，但是这种方法只进行了一次交换就完成了，
        // 遍历四分之一的元素就可以使所有的元素交换到本来应该到达的位置(因为有4个边，相当于交换一个循环)
        int n=matrix.length;
        for (int i=0; i<n/2; i++)
            for (int j=i; j<n-i-1; j++) {
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=tmp;
            }
    }*/
}

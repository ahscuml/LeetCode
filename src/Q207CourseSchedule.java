import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ahscuml
 * @date 2019/1/3
 * @time 20:01
 */
public class Q207CourseSchedule {
    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] preprequisites = {{1, 0}};

        System.out.println(canFinishBFS(numCourses, preprequisites));
    }

    /**
     * 利用BFS方法
     */
    public static boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        // BFS
        // 总共有多少个pairs
        int length = prerequisites.length;
        // 相当于建立一个图，课程关联的图  提前学的 > 学的
        int[][] matrix = new int[numCourses][numCourses];
        // 每个节点入度
        int[] indegree = new int[numCourses];

        for (int i = 0; i < length; i++) {
            // 要提前学的
            int pre = prerequisites[i][1];
            // 不用提前学的
            int ready = prerequisites[i][0];
            // 入队加1
            indegree[ready]++;
            matrix[pre][ready] = 1;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // 入队为0的节点，就是不需要提前学习的
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            // 出队
            int temp = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[temp][i] == 1) {
                    // 入度减少
                    indegree[i]--;
                    // 如果没有入度(先修课程全部学完)可以入队
                    if (indegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}

/**
 * @author ahscuml
 * @date 2018/10/21
 * @time 12:29
 */
public class Q79WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board,word));
    }

    /**
     * 利用递归算法来做
     * */
    public static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, int i, int j, String word, int index) {
        // 长度匹配，返回
        if(index == word.length()) {
            return true;
        }
        // 检测边界条件以及是否匹配
        if(i < 0 || i > board.length - 1 || j< 0 || j > board[0].length- 1 || board[i][j]!=word.charAt(index)) {
            return false;
        }
        // 已经匹配，当前元素变成不可用
        board[i][j]='*';
        // 递归，如果没有找到，就返回上一级
        boolean result =    exist(board, i-1, j, word, index+1) ||
                exist(board, i, j-1, word, index+1) ||
                exist(board, i, j+1, word, index+1) ||
                exist(board, i+1, j, word, index+1);
        board[i][j] = word.charAt(index);
        return result;
    }
}

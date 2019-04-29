import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树从头到尾的路径
 * @author ahscuml
 * @date 2019/4/29
 * @time 13:00
 */
public class Q257BinaryTreePaths {
    /**
     * 测试函数
     */
    public static void main(String[] args) {

    }

    /**
     * 将StringBuilder作为传递资源完成内容。
     * setLength函数设置长度
     * 最后一个不用加上->，所以需要判断当前节点的左右子节点是否是null
     * */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, root, sb);
        return res;
    }

    private void helper(List<String> res, TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            helper(res, root.left, sb);
            helper(res, root.right, sb);
        }
        sb.setLength(len);
    }
}

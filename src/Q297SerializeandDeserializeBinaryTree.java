/**
 * @author ahscuml
 * @date 2019/5/13
 * @time 23:32
 */

import util.TreeNode;

public class Q297SerializeandDeserializeBinaryTree {
    int index = -1;

    /**
     * 测试函数
     */
    public static void main(String[] args) {

    }

    /**
     * 序列化和反序列化，这是一个运行时间相对优秀的答案
     * 主要利用前序遍历，将一棵树组装成一个String
     * 反序列化同理，同样要注意反序列化的顺序
     * */
    private void serializeNode(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append('#').append(",");
            return;
        }
        sb.append(node.val).append(',');
        serializeNode(node.left, sb);
        serializeNode(node.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeNode(root, sb);
        return sb.substring(0, sb.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] val = data.split(",");
        return buildTree(val);
    }

    private TreeNode buildTree(String[] val) {
        index++;
        TreeNode cur = null;
        if (!val[index].equals("#")) {
            cur = new TreeNode(Integer.valueOf(val[index]));
            cur.left = buildTree(val);
            cur.right = buildTree(val);
        }
        return cur;
    }
}

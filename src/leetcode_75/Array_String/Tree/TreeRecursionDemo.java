package leetcode_75.Array_String.Tree;

public class TreeRecursionDemo {

    private static int depth = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        dfs(root);
    }

    public static void dfs(TreeNode node) {
        depth++;

        String indent = "  ".repeat(depth - 1);

        if (node == null) {
            System.out.println(indent + "【遇到 null】return");
            depth--;
            return;
        }

        System.out.println(
                indent + "【进入】节点 " + node.value
        );

        System.out.println(
                indent + "【处理】节点 " + node.value
        );

        System.out.println(
                indent + "→ 准备进入 " + node.value + " 的左子树"
        );

        dfs(node.left);

        System.out.println(
                indent + "← 节点 " + node.value + " 的左子树处理完成"
        );

        System.out.println(
                indent + "→ 准备进入 " + node.value + " 的右子树"
        );

        dfs(node.right);

        System.out.println(
                indent + "← 节点 " + node.value + " 的右子树处理完成"
        );

        System.out.println(
                indent + "【退出】节点 " + node.value
        );

        depth--;
    }

    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }
}
package binary_tree.about_traversal;

public class TreeNode {
    public int val;
    public TreeNode left;   // 记录左孩子结点，可能为 null，代表左孩子不存在
    public TreeNode right;  // 记录有孩子结点，可能为 null，代表有孩子不存在

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return String.format("TreeNode{%c}", this.val);
    }
}


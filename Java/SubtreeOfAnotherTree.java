import atomic.TreeNode;

public class SubtreeOfAnotherTree {
    TreeNode root, subRoot;

    public static void main(String[] args) {

        SubtreeOfAnotherTree tree = new SubtreeOfAnotherTree();

        tree.root = new TreeNode(26);
        tree.root.right = new TreeNode(3);
        tree.root.right.right = new TreeNode(3);
        tree.root.left = new TreeNode(10);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.left.right = new TreeNode(30);
        tree.root.left.right = new TreeNode(6);

        tree.subRoot = new TreeNode(10);
        tree.subRoot.right = new TreeNode(6);
        tree.subRoot.left = new TreeNode(4);
        tree.subRoot.left.right = new TreeNode(30);

        if (isSubtree(tree.root, tree.subRoot))
            System.out.println(
                    "Tree 2 is subtree of Tree 1 ");
        else
            System.out.println(
                    "Tree 2 is not a subtree of Tree 1");

    }

    public static boolean isSame(TreeNode root, TreeNode subRoot) {

        /* base cases */
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        /* Check if the data of both roots is same and data
           of left and right subtrees are also same */
        return (root.val == subRoot.val
                && isSame(root.left, subRoot.left)
                && isSame(root.right, subRoot.right));
    }

    /* This function returns true if S is a subtree of T,
     * otherwise false */
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        /* base cases */
        if (subRoot == null) return true;
        if (root == null) return false;

        /* Check the tree with root as current node */
        if (isSame(root, subRoot)) return true;

        /* If the tree with root as current node doesn't
           match then
           try left and right subtrees one by one */
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}

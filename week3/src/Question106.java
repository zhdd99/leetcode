/**
 * 从中序与后序遍历序列构造二叉树
 */
public class Question106 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return recur(inorder, 0, postorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode recur(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
        if (istart == iend) {
            return new TreeNode(postorder[pend]);
        }
        TreeNode root = new TreeNode(postorder[pend]);
        int k = 0;
        for (int i = istart; i <= iend; i++) {
            if (inorder[i] == postorder[pend]) {
                k = i;
                break;
            }
        }
        if (k > istart) {
            root.left = recur(inorder, istart, k - 1, postorder, pstart, pstart + k - 1 - istart);
        }
        if (k < iend) {
            root.right = recur(inorder, k + 1, iend, postorder, pstart + k - istart, pend - 1);
        }
        return root;
    }
}

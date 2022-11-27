import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangdongdong <zhangdongdong@kuaishou.com>
 * Created on 2022-11-27
 */
public class BinaryTreeMaximumPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int maxPathSum(TreeNode root) {
        f = new HashMap<>();
        f.put(null, new int[]{0, 0});
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode node) {
        if (null == node) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        int nodeHeight = node.val + Math.max(0, Math.max(f.get(node.left)[0], f.get(node.right)[0]));
        int nodeSum = node.val + Math.max(0, f.get(node.left)[0]) + Math.max(0, f.get(node.right)[0]);
        ans = Math.max(ans, nodeSum);
        f.put(node, new int[] {nodeHeight, nodeSum});
    }
    Map<TreeNode, int[]> f;
    int ans;
}

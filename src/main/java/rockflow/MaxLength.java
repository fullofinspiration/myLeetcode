package rockflow;

import com.fullofinspiration.github.tool.TreeNode;

public class MaxLength {
    public int maxLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxLength(root.left), maxLength(root.right));
    }
}

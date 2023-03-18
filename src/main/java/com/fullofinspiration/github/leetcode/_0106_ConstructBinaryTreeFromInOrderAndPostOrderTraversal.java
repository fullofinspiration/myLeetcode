package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _0106_ConstructBinaryTreeFromInOrderAndPostOrderTraversal {
    /**
     * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solutions/166210/super-simple-java-solution-beat-100/?orderBy=most_votes&page=2
     * 1 后序遍历最后一个元素是中间的元素，根据该元素的值, 从inorder中找到idx，则[low,idx-1]为左子树，[idx+1, high]为右子树，
     * 由于后续遍历和中序遍历唯一区别是后序遍历将root放在中间，所以postOrder[low, idx-1]为左子树，postOrder[idx, high-1]为右子树, 如果每次都保存后序遍历的影射关系，会比较复杂，还是像参考答案这样写比较好
     * 2 后序遍历的元素依次取出来，依次为右边root（如果有的话）左边root，
     */

    class Solution {
        private Map<Integer, Integer> value2Idx;
        private int postOrderLastIdx;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            value2Idx = value2Idx(inorder);
            postOrderLastIdx = inorder.length - 1;
            return doBuildTree(inorder, postorder, 0, postorder.length - 1);
        }

        private TreeNode doBuildTree(int[] inorder, int[] postorder, int low, int high) {
            if (low > high) {
                return null;
            }
            int idx = value2Idx.get(postorder[postOrderLastIdx--]);
            if (idx < low || idx > high) {
                throw new IllegalStateException();
            }
            TreeNode node = new TreeNode(inorder[idx]);
            node.right = doBuildTree(inorder, postorder, idx + 1, high);
            node.left = doBuildTree(inorder, postorder, low, idx - 1);
            return node;
        }

        private Map<Integer, Integer> value2Idx(int[] inorder) {
            Map<Integer, Integer> value2Idx = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                value2Idx.put(inorder[i], i);
            }
            return value2Idx;
        }
    }
}

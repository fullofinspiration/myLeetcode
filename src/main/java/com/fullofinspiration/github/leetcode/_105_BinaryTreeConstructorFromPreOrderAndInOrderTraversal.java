package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;

import java.util.HashMap;
import java.util.Map;


public class _105_BinaryTreeConstructorFromPreOrderAndInOrderTraversal {
    /**
     * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/255811/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/?envType=study-plan-v2&envId=top-100-liked
     * <p>
     * <p>
     * 开始时间：18:54
     * 结束时间19:54
     * 耗时 1h
     * TODO 非递归写法实现
     */
    class Solution {
        private Map<Integer, Integer> value2Idx = new HashMap<>();
        private int[] preorder;
        private int[] inorder;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;
            for (int i = 0; i < inorder.length; i++) {
                value2Idx.put(inorder[i], i);
            }
            return traceback(0, preorder.length - 1, 0, inorder.length - 1);
        }

        private TreeNode traceback(int preLeft, int preRight, int inLeft, int inRight) {
            if (preLeft > preRight) {
                return null;
            }
            if (inLeft > inRight) {
                return null;
            }
            int i = preorder[preLeft];
            int inIdx = value2Idx.get(i);
            TreeNode treeNode = new TreeNode(i);
            treeNode.left = traceback(preLeft + 1, preLeft + inIdx - inLeft,
                    inLeft, inIdx - 1);
            treeNode.right = traceback(preLeft + inIdx - inLeft + 1, preRight,
                    inIdx + 1, inRight);
            return treeNode;
        }
    }

    class Solution00 {
        /**
         * int[] preOrder, int[] inOrder
         * Map<Integer, Integer> preVal2Index;
         * Map<Integer, Integer> inOrder2Index;
         * //先序遍历时每个节点的前一个节点
         * Map<Integer, Node> node2Pre;
         * if(preOrder == null || preOrder.length =0) {
         * return null;
         * }
         * Node curNode = new Node(preOrder[0]);
         * Node root = curNode;
         * for(int i=0;i<preOrder.length;i++){
         * int nextValue = preOrder.get(i);
         * Node nextNode = new Node(nextValue);
         * if(inOrder2Index.get(nextValue) < inOrderIndex.get(curValue)) {
         * curNode.left=nextNode;
         * node2Pre.put(nextValue, curValue);
         * } else {
         * //最多遍历到跟节点
         * for (Node node = curNode;;node=node2Pre.get(nextValue)) {
         * //所有的pre节点肯定都已经有值了
         * if (inOrder2Index.get(node.val) < inOrder2Index.get(node)) {
         * curNode.nextNode = nextNode;
         * break;
         * }
         * }
         * }
         * curNode = nextNode;
         * }
         * return root;
         */
    }
}

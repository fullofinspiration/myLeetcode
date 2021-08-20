package com.fullofinspiration.github.leetcode;

/**
 * todo impl
 * List<List<Integer>> allValues = new ArrayList<>();
 * if (root == null)  {
 *     return allValues;
 * }
 * List<Node> all = new ArrayList<>();
 * all.add(root);
 * while(all.size > 0) {
 *     List<Integer> curValues = new ArrayList<>();
 *     List<Node> nextNodes = new ArrayList();
 *     for(int i=0, i< all.size();i++) {
 *         Node curNode =  all.get(i);
 *         curValues.add(curNode.value);
 *         if (curNode.left!=null) {
 *            nextNodes.add(curNode.left);
 *         }
 *         if (curNode.right!=null) {
 *             nextNodes.add(curNode.right);
 *         }
 *     }
 *     allValues.add(curValues);
 *     all= nextNodes;
 * }
 */
public class _0102_BinaryTreeLevelOrderTraversal {
}

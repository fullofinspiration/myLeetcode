package com.fullofinspiration.github.leetcode;

/**
 * int[] preOrder, int[] inOrder
 * Map<Integer, Integer> preVal2Index;
 * Map<Integer, Integer> inOrder2Index;
 * //先序遍历时每个节点的前一个节点
 * Map<Integer, Node> node2Pre;
 * if(preOrder == null || preOrder.length =0) {
 *     return null;
 * }
 * Node curNode = new Node(preOrder[0]);
 * Node root = curNode;
 * for(int i=0;i<preOrder.length;i++){
 *    int nextValue = preOrder.get(i);
 *    Node nextNode = new Node(nextValue);
 *    if(inOrder2Index.get(nextValue) < inOrderIndex.get(curValue)) {
 *        curNode.left=nextNode;
 *        node2Pre.put(nextValue, curValue);
 *    } else {
 *        //最多遍历到跟节点
 *        for (Node node = curNode;;node=node2Pre.get(nextValue)) {
 *          //所有的pre节点肯定都已经有值了
 *          if (inOrder2Index.get(node.val) < inOrder2Index.get(node)) {
 *              curNode.nextNode = nextNode;
 *              break;
 *          }
 *        }
 *    }
 *    curNode = nextNode;
 * }
 * return root;
 *
 *
 */
public class _105_BinaryTreeConstructorFromPreOrderAndInOrderTraversal {

}

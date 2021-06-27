package com.fullofinspiration.github.leetcode;

/**
 * 递归：
 * if (node.left != null) {
 *     print left;
 * }
 * print(node.val);
 * if (node.right != null) {
 *     print(node.right)
 * }
 * 非递归：
 * 使用栈
 * Stack stack = new Stack();
 * Node curNode = head;
 * while(curNode!=null || !stack.empty()) {
 *     if (curNode == null){
 *         curNode = stack.pop();
 *     }
 *     if (curNode.left != null) {
 *         stack.push(curNode);
 *         curNode = curNode.left;
 *         continue;
 *     }
 *     print(curNode.val);
 *     curNode = curNode.right;
 * }
 */
public class _0094_BinaryTreeInorderTraversal {

}

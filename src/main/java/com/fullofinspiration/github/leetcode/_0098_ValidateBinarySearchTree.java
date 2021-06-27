package com.fullofinspiration.github.leetcode;

/**
 * 递归方式是代码是最简单的
 * boolean validateIsBST(Node root) {
 *     if (root == null) {
 *         return true;
 *     }
 *     if (root.left != null && root.value<= root.left.value){
 *         return false;
 *     }
 *     if (root.right !=null && root.value >=root.right.value) {
 *         return false;
 *     }
 *     return validateIsBST(root.left) && validateIsBST(root.right);
 * }
 */
public class _0098_ValidateBinarySearchTree {
}

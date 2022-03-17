package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhang.zhenpeng_203631@immomo.com
 * @date 2022/1/31 5:57 PM
 */
public class MidBinarySearcher {

  public List<Integer> midBinarySearch(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    TreeNode curNode = root;
    LinkedList<TreeNode> stack = new LinkedList<>();
    List<Integer> rst = new ArrayList<>();
    while (true) {
      System.out.println(curNode);
      while (curNode != null) {
        System.out.println("abc");
        stack.push(curNode);
        curNode = curNode.left;
      }
      if (stack.isEmpty()) {
        return rst;
      }
      TreeNode poppedNode = stack.pop();
      rst.add(poppedNode.val);
      curNode = poppedNode.right;
    }
  }
}

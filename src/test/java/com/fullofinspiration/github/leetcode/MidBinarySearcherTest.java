package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.tool.ListNode;
import com.fullofinspiration.github.tool.TreeNode;
import com.fullofinspiration.github.util.ListNodeUtil;
import com.fullofinspiration.github.util.ListUtil;
import com.fullofinspiration.github.util.TreeNodeUtil;
import com.google.common.collect.ImmutableList;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhang.zhenpeng_203631@immomo.com
 * @date 2022/1/31 6:03 PM
 */
public class MidBinarySearcherTest extends TestCase {

  /**
   * 2
   * /\
   * 1 3
   */
  @Test
  public void test00() {
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode1 = new TreeNode(1);
    TreeNode treeNode3 = new TreeNode(3);
    treeNode2.left = treeNode1;
    treeNode2.right = treeNode3;
    MidBinarySearcher midBinarySearcher = new MidBinarySearcher();
    List<Integer> rst = midBinarySearcher.midBinarySearch(treeNode2);
    List<Integer> expected = ImmutableList.of(1, 2, 3);
    boolean equal = ListUtil.equal(expected, rst);
    Assert.assertTrue(equal);

  }
}
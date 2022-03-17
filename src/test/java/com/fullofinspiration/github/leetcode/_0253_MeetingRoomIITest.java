package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.leetcode._0253_MeetingRoomII.Solution;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhang.zhenpeng_203631@immomo.com
 * @date 2022/1/27 5:08 PM
 */
public class _0253_MeetingRoomIITest extends TestCase {

  private static final Solution SOLUTION = new _0253_MeetingRoomII().new Solution();

  @Test
  public void test00() {
    int[] first = {0, 30};
    int[] second = {5, 10};
    int[] third = {15, 20};
    int[][] input = {first, second, third};
    int i = SOLUTION.minMeetingRooms(input);
    Assert.assertEquals(2, i);
  }

  @Test
  public void test01() {
    int[] first = {7, 10};
    int[] second = {2, 4};
    int[][] input = {first, second};
    int i = SOLUTION.minMeetingRooms(input);
    Assert.assertEquals(1, i);
  }
}
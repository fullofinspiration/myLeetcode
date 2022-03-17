package com.fullofinspiration.github.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhang.zhenpeng_203631@immomo.com
 * @date 2022/1/27 4:59 PM
 */
public class _0253_MeetingRoomII {

  /**
   * 看的官方题解，还有一种解法更简单，按开始和结束两个队列排序，然后计数，时间关系，先不写了
   */
  class Solution {

    public int minMeetingRooms(int[][] intervals) {
      Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

      PriorityQueue<int[]> all = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

      for (int[] interval : intervals) {
        if (all.peek() == null || interval[0] < all.peek()[1]) {
          all.add(interval);
          continue;
        }
        all.poll();
        all.add(interval);
      }
      return all.size();
    }
  }

}

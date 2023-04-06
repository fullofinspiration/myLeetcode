package com.fullofinspiration.github.leetcode;

/**
 * hard
 */
public class _0004_MedianOfTwoSortedArrays {
  class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
      int mid1 = (a.length + b.length) / 2;
      int mid2 = (a.length + b.length - 1) / 2;
      int res1 = doFindMedian(a, b, mid1);
      int res2 = doFindMedian(a, b, mid2);
      return ((double) res1 + res2) / 2;
    }

    private int doFindMedian(int[] a, int[] b, int targetIdx) {
      int idx1 = 0, idx2 = 0;
      while (a.length > idx1 || b.length > idx2) {
        if (idx1 >= a.length) {
          return b[targetIdx - a.length];
        }
        if (idx2 >= b.length) {
          return a[targetIdx - b.length];
        }
        if (idx1 + idx2 == targetIdx) {
          return Math.min(a[idx1], b[idx2]);
        } else if (a[idx1] < b[idx2]) {
          idx1++;
        } else {
          idx2++;
        }
      }
      throw new RuntimeException();
    }
  }

  /**
   * 太难了看不懂：https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/2471/very-concise-o-log-min-m-n-iterative-solution-with-detailed-explanation/?orderBy=most_votes
   * 实在太复杂了，不写了
   * <p>
   * 难点：
   * 1：两个数组长度不一样
   * 2：范围确定很难
   * 3: 有可能有2个值，有可能有一个值
   * 4：两个int做除法需要先转换成double
   * if (aHigh<bLow) {
   * if (ith<aHigh.length) {
   * return a[ith];
   * } else {
   * return b[i-ith]
   * };
   * } else if (...) {
   * ...
   * } else {
   * <p>
   * }
   * 结果：取((a.length+b.length)/2 + (a.length+b.length+1)/2) /2 求得的是第几个值
   * if aMid-aLow+bMid-bLow == ith return Math.max(aMid, bMid)
   * else if aMid-aLow+bMid-bLow > ith  aHigh = aMid-1 bHigh = bMid-1
   * else if aMid-aLow+bMid-bLow < ith
   */
  class Solution01 {
    public double findMedianSortedArrays(int[] a, int[] b) {
      return 0;
    }

    private int findValueOfIdx(int[] a, int aLow, int aHigh, int[] b, int bLow, int bHigh, int ith) {
      if (ith == 1) {
        return Math.min(a[aLow], b[bLow]);
      }
      int aMid = (aLow + aHigh) / 2;
      int bMid = (bLow + bHigh) / 2;
      return 0;
    }
  }

  class Solution00 {

    public double findMedianSortedArrays(int[] a, int[] b) {
      if (a == null || b == null) {
        throw new IllegalArgumentException();
      }
      if (a.length <= b.length) {
        return doCalcReward(a, b);
      }
      return doCalcReward(b, a);
    }

    private double doCalcReward(int[] first, int[] second) {
      int lowA = 0;
      int highA = first.length;
      while (lowA <= highA) {
        int partitionA = (lowA + highA) / 2;
        int partitionB = (first.length + second.length + 1) / 2 - partitionA;
        int aLeftMax = partitionA == 0 ? Integer.MIN_VALUE : first[partitionA - 1];
        int aRightMin = partitionA == first.length ? Integer.MAX_VALUE : first[partitionA];
        int bLeftMax = partitionB == 0 ? Integer.MIN_VALUE : second[partitionB - 1];
        int bRightMin = partitionB == second.length ? Integer.MAX_VALUE : second[partitionB];
        if (aLeftMax <= bRightMin && bLeftMax <= aRightMin) {
          if ((first.length + second.length) % 2 == 0) {
            return
                    ((double) (Math.max(aLeftMax, bLeftMax) + Math.min(aRightMin, bRightMin)))
                            / 2;
          }
          return Math.max(aLeftMax, bLeftMax);
        }
        if (aLeftMax > bRightMin) {
          String msg = String.format(
                  "Set HighA minus 1: %s. cur low a: %s, cur high a: %s, cur partition a: %s cur partition b: %s.",
                  partitionA - 1, lowA, highA, partitionA, partitionB);
          System.out.println(msg);
          highA = partitionA - 1;
          continue;
        }
        String msg = String.format(
                "Set lowA plus 1: %s. cur low a: %s, cur high a: %s, cur partition a: %s cur partition b: %s.",
                partitionA + 1, lowA, highA, partitionA, partitionB);
        System.out.println(msg);
        lowA = partitionA + 1;
      }

      throw new IllegalArgumentException();
    }
  }
//  public double findMid(int[] first, int[] second) {
//    if (first == null && second == null) {
//      return -1;
//    }
//
//    if (first == null) {
//      return getMid(second);
//    }
//
//    if (second == null) {
//      return getMid(first);
//    }
//
//    /**
//     * 只需要有一个
//     */
//    if ((first.length + second.length) % 2 != 0) {
//      int total = first.length + second.length;
//
//      int mid = total / 2;
//
//      int firstLow = 0;
//      int firstHigh = first.length - 1;
//
//      int secondLow = 0;
//      int secondHigh = second.length - 1;
//
//      int firstMid = (firstLow + firstHigh) / 2;
//      int secondMid = (secondLow + secondHigh) / 2;
//
//      if (firstMid + secondMid + 2 == mid) {
//        return Math.max(first[firstMid], second[secondMid]);
//      }
//
//      if ()
//    }
//
//  }
//
//  private double getMid(int[] arrays) {
//    if (arrays.length % 2 == 0) {
//      return (double) (arrays[arrays.length / 2 - 1] + arrays[arrays.length / 2]) / 2;
//    }
//    return arrays[arrays.length / 2];
//  }
}

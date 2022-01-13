package com.fullofinspiration.github.leetcode;

/**
 * hard
 * todo impl
 */
public class _0004_MedianOfTwoSortedArrays {

  class Solution {

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

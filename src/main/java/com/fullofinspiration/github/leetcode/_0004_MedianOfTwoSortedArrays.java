package com.fullofinspiration.github.leetcode;

/**
 * hard
 */
public class _0004_MedianOfTwoSortedArrays {
  /**
   * https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/2471/very-concise-o-log-min-m-n-iterative-solution-with-detailed-explanation/?orderBy=most_votes
   * 1 Solution00调试了很久，异常case处理相对繁琐且易出错
   * 1 保证不论长度为奇数还是偶数，都有统一的处理方式
   * 2 代码比较优雅，不易出错
   * <p>
   * 1 选取数组长度小的数组进行迭代
   * 2 定义数组左节点和右节点：假如数组长度为偶数，则刚好可以切成两部分，
   * 假如数组长度为奇数，定义左边最大节点和右边最小节点为同一个节点：[1,2,3], 则左边最大节点是2 ，右边最小节点也是2，方便进行统一处理
   * [1,2,3] len:3 leftMaxIdx:1(n-1)/2,  rightMinIdx:1 n/2  [1,2,3,4] len:4 leftMaxIdx:1(n-1)/2 rightMinIdx:2 n/2
   * 3 将可以分割的地方放入到每个数组中，假如数组为[0,1,2],可能切的点有[x,0,x,1,x,2,x] 此时此时可能切得地点有2n+1, 索引：0~2n
   * 4 两个数组时，求得A数组切入点为partitionA时，求partitionB：
   * 当前可以切的总数量是2(N1+N2) + 2,切入点占用两个，所以总数是2N，保证左边和右边数量分别都是N1+N2（不太能直接想出这种方式，但是想不到更简洁的方式了）
   * 所以partitionB=N1+N2-partitionA(假如partitionA是1，代表左边有1个，保证该公式成立，需要保证array2的左边有N1+N2-1个，所以partition2索引为N1+N2-1)
   * 5 left, right如何根据partition求得
   * 通过举例进行映射:[0,1,2] [x,0,x,1,x,2,x]
   * 1)切的点索引是2时([x,0,|,1,x,2,x])，左边索引是0，右边索引是1，(2-1)/2 2/2
   * 2)切得点索引是3时[x,0,x,1/1,x,2,x] 左边索引是1,右边索引是1， (3-1)/2 3/2
   * 所以左边节点是(partition-1) / 2 右边节点是partition/2
   */
  class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
      if (a == null && b == null) {
        throw new IllegalArgumentException();
      }
      if (a == null || a.length == 0) {
        return (double) (b[(b.length - 1) / 2] + b[b.length / 2]) / 2;
      }
      if (b == null || b.length == 0) {
        return findMedianSortedArrays(b, a);
      }
      if (a.length > b.length) {
        return findMedianSortedArrays(b, a);
      }
      int low = 0, high = a.length * 2;
      while (low <= high) {
        int partitionA = (low + high) / 2;
        int partitionB = a.length + b.length - partitionA;
        int aLeftMax = partitionA == 0 ? Integer.MIN_VALUE : a[ (partitionA - 1) / 2];
        int bLeftMax = partitionB == 0 ? Integer.MIN_VALUE : b[(partitionB - 1) / 2];
        int aRightMin = partitionA == a.length * 2 ? Integer.MAX_VALUE : a[partitionA / 2];
        int bRightMin = partitionB == b.length * 2 ? Integer.MAX_VALUE :b[ partitionB / 2];
        if (aLeftMax > bRightMin) {
          high = partitionA - 1;
        } else if (bLeftMax > aRightMin) {
          low = partitionA + 1;
        } else {
          return (double) (Math.max(aLeftMax, bLeftMax) + Math.min(aRightMin, bRightMin)) / 2;
        }
      }
      throw new IllegalArgumentException();
    }
  }

  class Solution02 {
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

  /**
   * 只从小的遍历原因：这样可以保证每个分区点都能在长的数组中找到对应的位置
   * partitionB：（aLength+bLength + 1） / 2 - partitionA
   * 为什么需要加1：
   * 假如长度和为偶数：4，所有左边的和长度为2，若partitionA=1， A左边加和为1， 为了保证B左边加和为1，partitionB=1,1 对应着4/2-1=1
   * 假如长度和为奇数：5，所有左边的和长度为3，若partitionA=1， A左边加和为1， 为了保证B左边加和为2，partitionB=2,1 对应着（5+1）/2-1=2
   * 为什么aLeftMax==bRightMin时需要aLow++: 看不出来
   */
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

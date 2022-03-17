package com.fullofinspiration.github.interview;

/**
 * @author zhang.zhenpeng_203631@immomo.com
 * @date 2022/3/16 8:57 PM
 */
public class QuickSort01 {

  public void quickSort(int[] arrs) {
    quickSort(arrs, 0, arrs.length - 1);
  }

  public void quickSort(int[] arrs, int lowIdx, int highIdx) {
    int curLow = lowIdx;
    int curHigh = highIdx;
    int pivot = arrs[lowIdx];
    while (lowIdx <= highIdx) {
      while (arrs[highIdx] >= pivot && lowIdx <= highIdx) {
        highIdx--;
      }
      arrs[lowIdx++] = arrs[highIdx];
      while (arrs[lowIdx] <= pivot && lowIdx <= highIdx) {
        highIdx++;
      }
      arrs[highIdx--] = arrs[lowIdx];
    }
    arrs[lowIdx] = pivot;
    quickSort(arrs, curLow, lowIdx-1);
    quickSort(arrs, lowIdx + 1, curHigh);
  }
}

package com.fullofinspiration.github.leetcode;

/**
 * 将所有值放入到linkedHashMap中
 * SortedList<Integer>all =  buildSortedList();
 * for(int i=0;i< all.length;i++) {
 *     List<Integer>curList = List.copyOf(all);
 *     tranverse(all.get(i), curList.remove(all.get(i)));
 * }
 * int tranverse(int value, SortedList<Integer> all)
 * if (all.size() == 0){
 *     return 1;
 * }
 *
 * int leftCount=0;
 * int rightCount=0;
 *Integer lessThanValue = all.getFirstLessThan(value);
 * if (lessThanValue !=null) {
 *    List<Integer>curList = List.copyOf(all);
 *    leftCount = tranverse(lessThanValue, curList.remove(lessThanValue));
 * }
 * Integer graterThanValue = all.getFirstGraterThan(value);
 * if (graterThanValue !=null) {
 *    List<Integer>curList = List.copyOf(all);
 *    rightCount = tranverse(graterThanValue, curList.remove(graterThanValue));
 * }
 * return leftCount +  rightCount;
 *
 */
public class _0096_UniqueBinarySearchTreeCount {

}

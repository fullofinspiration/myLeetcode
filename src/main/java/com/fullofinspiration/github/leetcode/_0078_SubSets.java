package com.fullofinspiration.github.leetcode;

/**
 * 对于每个长度，都调用一次该函数，最终求得所有的值
 * 对于长度为length的datas[], 求长度为length4SubSet所有子数组函数:
 * def List<List<String>> getSubSet(datas[]) {
 *
 * }
 * maxVal = 数组中最大值
 * map<Integer, Integer> val2Index 值对应的索引
 * def List<List<String>> getSubSet(int targetLength):
 *     List<List<String>> allValues = new ArrayList<>();
 *     for(int curLength=0; curLength < targetLength; curLength++):
 *       for(List<Integer> value: allValues):
 *          //每次增加的值都会放入到该数组中，这里作为遍历终止的条件
 *          if (value.size() > curLength)
 *             break;
 *          for(int index = val2Index.get(value.get(value.size()-1))+1; index < data.length; index++):
 *               value.add(array[index]);
 *               allValues.add(value);
 *
 *
 *
 */
public class _0078_SubSets {
}

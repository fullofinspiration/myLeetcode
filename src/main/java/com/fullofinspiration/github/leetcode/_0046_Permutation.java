package com.fullofinspiration.github.leetcode;

/**
 * 计算所有排列 根据n! = n * (n-1)... * 1方式
 * while循环每次都往每个元素中加一个值，第一次n个值（list中共n个值），
 * 第二次n-1个值，直到最后加一个值，每次从小到大，来保证遍历一次就能遍历所有的值
 * 判断已有值中是否包含新加的值：list.contains() 该方式节省内存，但是耗费cpu
 */
public class _0046_Permutation {
}

package com.fullofinspiration.github.leetcode;

/**
 * 使用递归比较好实现些
 * curStairCount:当前楼梯高度
 * 1 定义方法countPath(int curStairCount):
 *    if (curStairCount == count):
 *        return 1;
 *    elif (curStairCount > count):
 *       return 0;
 *    else:
 *        return countPath(curStairCount+1) + countPath(curStairCount+2)
 */
public class _0070_ClimbingStairs {
}

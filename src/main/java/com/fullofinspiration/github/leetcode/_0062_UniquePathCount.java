package com.fullofinspiration.github.leetcode;


import java.util.Arrays;

public class _0062_UniquePathCount {
    /**
     * 每次遍历一行，然后遍历第二行 f(m, n) = f(m-1,n)+f(m,n-1),
     * 每次只需要保留长度为n+1的一维数组，arr[0]=0 arr[1...n]=1 每次从前向后遍历curVal[i]+=curVal[i-1]
     */
    class Solution {
        public int uniquePaths(int m, int n) {
            int[] ints = new int[n];
            Arrays.fill(ints, 1);
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    ints[j] += ints[j - 1];
                }
            }
            return ints[n - 1];
        }
    }

    /**
     * 在解决方案中，好像没有什么算法比递归更合适了
     * 对每个节点，判断是否有下一个节点可走
     * 如果有下一个节点可走，之前所有走法数量之和 * 后面走法数量之和
     * 终止条件：最终走到了终点(右下角)
     */
    class Solution00 {
        public int uniquePaths(int m, int n) {
            return 0;
        }
    }
}

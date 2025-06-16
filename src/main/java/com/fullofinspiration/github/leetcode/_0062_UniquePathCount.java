package com.fullofinspiration.github.leetcode;


import java.util.Arrays;

public class _0062_UniquePathCount {

    /**
     * 空间复杂度较高
     */
    class Solution {
        public int uniquePaths(int m, int n) {
            int[] paths = new int[n];
            for (int i = 0; i < paths.length; i++) {
                paths[i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    paths[j] += paths[j - 1];
                }
            }
            return paths[n - 1];
        }
    }

    /**
     * 空间复杂度较高
     */
    class Solution03 {
        public int uniquePaths(int m, int n) {
            int[][] paths = new int[m][n];
            for (int i = 0; i < paths.length; i++) {
                paths[i][0] = 1;
            }
            for (int j = 0; j < paths[0].length; j++) {
                paths[0][j] = 1;
            }
            for (int i = 1; i < paths.length; i++) {
                for (int j = 1; j < paths[0].length; j++) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
            return paths[m - 1][n - 1];
        }
    }

    /**
     * f(m)(n) = f(m-1)(n)+ f(m)(n-1)
     */
    class Solution02 {
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
     * 每次遍历一行，然后遍历第二行 f(m, n) = f(m-1,n)+f(m,n-1),
     * 每次只需要保留长度为n+1的一维数组，arr[0]=0 arr[1...n]=1 每次从前向后遍历curVal[i]+=curVal[i-1]
     */
    class Solution01 {
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

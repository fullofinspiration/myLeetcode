package com.fullofinspiration.github.leetcode;

/**
 * 实际应用: 用来比较两个字符串的相似度
 */
public class _0072_EditDistance {
    /**
     * https://leetcode.com/problems/edit-distance/solutions/25849/java-dp-solution-o-nm/?orderBy=most_votes
     * 开始想要找到匹配的最长连续子数组，但是需要找到某个相同的子数组的位置，这种方式不需要考虑最终的字符串是怎么样的，
     * 不需要考虑当前是添加还是删除还是修改，只是暴力的取其中的最大值,这样是可以的，暂时不要把简单的问题复杂化，以后有机会再扩展同类的题目
     * m: 第一个字符串 n： 第二个字符串
     * f(m,n) 代表第n个字符串对第m个字符串的距离
     * if m == n: f(m,n)=f(m-1,n-1)
     * f(m,n) = max(f(m-1,n-1), f(m,n-1), f(m-1,n))
     * debug问题
     * 1 ： 应该是word1.charAt(i-1) 而不是word1.charAt(i)，注意到原数组索引的影射
     * 2： 应该是min，而不是max
     */
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int[][] all = new int[m + 1][n + 1];
            for (int i = 0; i < all.length; i++) {
                all[i][0] = i;
            }
            for (int i = 0; i < all[0].length; i++) {
                all[0][i] = i;
            }
            for (int i = 1; i < all.length; i++) {
                for (int j = 1; j < all[0].length; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        all[i][j] = all[i - 1][j - 1];
                        continue;
                    }
                    int tmp = Math.min(all[i - 1][j - 1], all[i][j - 1]);
                    int max = Math.min(tmp, all[i - 1][j]);
                    all[i][j] = max + 1;
                }
            }
            return all[m][n];
        }
    }
}

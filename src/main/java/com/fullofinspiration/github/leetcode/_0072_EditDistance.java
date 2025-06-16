package com.fullofinspiration.github.leetcode;

/**
 * 实际应用: 用来比较两个字符串的相似度
 */
public class _0072_EditDistance {
    /**
     * 错误1： 两个word取某个位置的值时应该是i-1，j-1
     * 错误2 数组取值应该是ret[rowLen-1][colLen-1] 而不是ret[rowLen][colLen];
     */
    class Solution {
        public int minDistance(String word1, String word2) {
            int rowLen = word1.length() + 1;
            int colLen = word2.length() + 1;
            int[][] ret = new int[rowLen][colLen];
            for (int i = 0; i < rowLen; i++) {
                ret[i][0] = i;
            }
            for (int i = 0; i < colLen; i++) {
                ret[0][i] = i;
            }
            for (int i = 1; i < rowLen; i++) {
                for (int j = 1; j < colLen; j++) {
                    int val1 = ret[i - 1][j] + 1;
                    int val2 = ret[i][j - 1] + 1;
                    int val3 = ret[i - 1][j - 1];
                    if (word1.charAt(i-1) != word2.charAt(j-1)) {
                        val3 += 1;
                    }
                    int minVal = Math.min(Math.min(val1, val2), val3);
                    ret[i][j] = minVal;
                }
            }
            return ret[rowLen-1][colLen-1];
        }
    }

    /**
     * 错误1：distance[i-1][j-1]也要考虑进去
     * 错误2： distance[i + 1][j + 1] = distance2+1没有+1
     */
    class Solution01 {
        public int minDistance(String word1, String word2) {
            int[][] distance = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i < distance.length; i++) {
                distance[i][0] = i;
            }
            for (int i = 0; i < distance[0].length; i++) {
                distance[0][i] = i;
            }
            for (int i = 0; i < word1.length(); i++) {
                for (int j = 0; j < word2.length(); j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        distance[i + 1][j + 1] = distance[i][j];
                        continue;
                    }
                    int distance1 = Math.min(distance[i][j + 1], distance[i + 1][j]);
                    int distance2 = Math.min(distance1, distance[i][j]);
                    distance[i + 1][j + 1] = distance2 + 1;
                }
            }
            return distance[word1.length()][word2.length()];
        }
    }

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
    class Solution00 {
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

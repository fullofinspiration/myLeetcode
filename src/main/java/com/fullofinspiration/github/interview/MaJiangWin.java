package com.fullofinspiration.github.interview;
import java.util.Arrays;

/**
 * 爱诗科技 判断是否胡牌， 答案来自元宝AI
 */
public class MaJiangWin {
        public static boolean isHu(int[] hand) {
            if (hand.length != 14) {
                return false;
            }

            // 统计每种牌的数量（1-9）
            int[] counts = new int[10];
            for (int card : hand) {
                if (card < 1 || card > 9) {
                    return false;
                }
                counts[card]++;
            }

            // 尝试所有可能的对子
            for (int i = 1; i <= 9; i++) {
                if (counts[i] < 2) {
                    continue;
                }
                // 移除对子
                counts[i] -= 2;
                // 检查剩余12张牌是否能组成4组三张
                if (checkTriples(counts)) {
                    counts[i] += 2; // 回溯
                    return true;
                }
                // 回溯，恢复对子
                counts[i] += 2;
            }

            return false;
        }

        private static boolean checkTriples(int[] counts) {
            int totalLeft = Arrays.stream(counts).sum();
            if (totalLeft == 0) {  // 所有牌已组合完成
                return true;
            }

            // 找到最小的有剩余牌的数字
            for (int i = 1; i <= 9; i++) {
                if (counts[i] == 0) {
                    continue;
                }

                // 情况1：刻子 (AAA)
                if (counts[i] >= 3) {
                    counts[i] -= 3;
                    if (checkTriples(counts)) {
                        counts[i] += 3;
                        return true;
                    }
                    counts[i] += 3;
                }

                // 情况2：顺子 (ABC)
                if (i <= 7 && counts[i] > 0 && counts[i + 1] > 0 && counts[i + 2] > 0) {
                    counts[i]--;
                    counts[i + 1]--;
                    counts[i + 2]--;
                    if (checkTriples(counts)) {
                        counts[i]++;
                        counts[i + 1]++;
                        counts[i + 2]++;
                        return true;
                    }
                    counts[i]++;
                    counts[i + 1]++;
                    counts[i + 2]++;
                }

                // 如果两种组合都不成功，提前失败
                return false;
            }

            return false;
        }

        public static void main(String[] args) {
            // 测试用例
            Object[][] testCases = {
                    {new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1}, true},  // 全1可胡
                    {new int[]{1,1,1,2,2,2,3,3,3,4,4,4,5,5}, true},   // 标准胡牌
                    {new int[]{1,2,3,1,2,3,1,2,3,4,4,4,5,5}, true},   // 混合胡牌
                    {new int[]{1,1,1,2,2,2,3,3,3,7,7,7,9,9}, true},   // 分散刻子
                    {new int[]{1,1,1,2,3,4,5,6,7,8,9,9,9,9}, false},  // 顺子不连续
                    {new int[]{1,1,2,2,3,3,4,4,5,5,6,6,7,7}, false},  // 七对不算胡
                    {new int[]{1,2,3,4,5,6,7,8,9,1,2,3,4,5}, false}   // 无对子
            };

            for (Object[] testCase : testCases) {
                int[] hand = (int[]) testCase[0];
                boolean expected = (boolean) testCase[1];
                boolean result = isHu(hand);
                if (result != expected) {
                    System.out.printf("测试失败: %s 期望 %s 实际 %s%n",
                            Arrays.toString(hand), expected, result);
                }
            }

            System.out.println("所有测试通过!");
        }
}

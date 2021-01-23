package com.fullofinspiration.github.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zhenpeng Zhang on 2021/1/1.
 * <p>
 * 网上最优的方法，有些取巧的意思，不过也很巧妙
 * 我自己方法有些笨拙，只适合工程，不适合刷题
 */
public class _0012Integer2Roman {

    public static void main(String[] args) {
        _0012Integer2Roman integer2Roman = new _0012Integer2Roman();
        System.out.println(integer2Roman.integer2Roman(1));
        System.out.println(integer2Roman.integer2Roman(5));
        System.out.println(integer2Roman.integer2Roman(9));
        System.out.println(integer2Roman.integer2Roman(10));
        System.out.println(integer2Roman.integer2Roman(11));
        System.out.println(integer2Roman.integer2Roman(1001));
    }

    public String integer2Roman(int num) {
        StringBuilder builder = new StringBuilder();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < 13; i++) {
            while (num >= nums[i]) {
                builder.append(symbols[i]);
                num -= nums[i];
            }
        }
        return builder.toString();
    }

    /**
     * 我自己的方法，有些笨拙
     */
    public static class MySolution {

        public String integer2Roman(int num) {
            int position = 1;
            String result = "";
            while (num != 0) {
                int curNum = num % 10;
                String subRoman = getRoman(curNum, elements.get(position));
                result = subRoman + result;
                num = num / 10;
                position++;
            }
            return result;
        }

        /**
         * position是位置，第1位，第2位
         * 0 <num < 9
         */
        private String getRoman(int num, Element element) {
            String one = element.getOne();
            String five = element.getFive();
            String ten = element.getTen();
            switch (num) {
                case 0:
                    return "";
                case 1:
                    return one;
                case 2:
                    return one + one;
                case 3:
                    return one + one + one;
                case 4:
                    return one + five;
                case 5:
                    return five;
                case 6:
                    return five + one;
                case 7:
                    return five + one + one;
                case 8:
                    return five + one + one + one;
                case 9:
                    return one + ten;
                default:
                    throw new RuntimeException("Invalid num: " + num);
            }
        }

        private static Map<Long, Element> elements = new HashMap() {{
            put(1, new Element("I", "V", "X"));
            put(2, new Element("X", "L", "C"));
            put(3, new Element("C", "D", "M"));
            put(4, new Element("M", "", ""));
        }};

        public static class Element {

            private String one;

            private String five;

            private String ten;

            private String getOne() {
                return one;
            }

            private String getFive() {
                return five;
            }

            private String getTen() {
                return ten;
            }

            public Element(String one, String five, String ten) {
                this.one = one;
                this.five = five;
                this.ten = ten;
            }
        }
    }
}

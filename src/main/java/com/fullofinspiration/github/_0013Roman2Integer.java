package com.fullofinspiration.github;

/**
 * Created by Zhenpeng Zhang on 2021/1/6.
 */
public class _0013Roman2Integer {

    public static void main(String[] args) {
        printVal("III");
        printVal("IV");
        printVal("IX");
        printVal("LVIII");
        printVal("MCMXCIV");
    }

    private static void printVal(String roman) {
        Solution solution = new Solution();
        int iii = solution.romanToInt(roman);
        System.out.println(iii);
    }

    private static class Solution {

        public int romanToInt(String s) {
            int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            int symbolIndex = 0;
            int result = 0;
            while (symbolIndex < symbols.length) {
                if (s.startsWith(symbols[symbolIndex])) {
                    result += vals[symbolIndex];
                    s = s.substring(symbols[symbolIndex].length());
                } else {
                    symbolIndex++;
                }
            }
            return result;
        }
    }

}

package com.fullofinspiration.github;

import java.util.ArrayList;

/**
 * z字形转换
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i <sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        int i = 0;
        while (i < len) {
            for (int j = 0; j < numRows && i < len; j++) {
                sb[j].append(c[i++]);
            }
            for (int j = numRows - 2; j > 0 && i < len; j--) {
                sb[j].append(c[i++]);
            }
        }

        StringBuilder sb1 = new StringBuilder();
        for (int j = 0; j < sb.length; j++) {
            sb1.append(sb[j]);
        }
        return sb1.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zc = new ZigzagConversion();
        String s = "PAYPALISHIRING";
        String s1 = zc.convert(s, 3);
        System.out.println(s1);
    }
}

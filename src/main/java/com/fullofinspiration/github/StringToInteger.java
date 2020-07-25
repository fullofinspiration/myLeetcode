package com.fullofinspiration.github;

public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.length() <= 0)
            return 0;
        int index = 0, flag = 1, total = 0;
        while (str.charAt(index) == ' ' && index < str.length())
            index++;
        if (str.charAt(index) == '+' || str.charAt(index) == '-')
            flag = str.charAt(index++) == '-' ? -1 : 1;
        while (index < str.length()) {
            int number = str.charAt(index++) - '0';
            if (number >= 0 && number <= 9) {
                if (flag == 1 && total > (Integer.MAX_VALUE - number) / 10)
                    return Integer.MAX_VALUE;
                if (flag == -1 && -total < (Integer.MIN_VALUE + number) / 10)
                    return Integer.MIN_VALUE;
                total *= 10;
                total += number;
            } else {
                return total * flag;
            }
        }
        return total * flag;
    }

    public static void main(String[] args) {
        String str = "2147483648";
        StringToInteger sti = new StringToInteger();
        int a = sti.myAtoi(str);
        System.out.println(a);
        System.out.println(Integer.MAX_VALUE);
    }
}

package com.fullofinspiration.github.util;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayUtil {
    public static boolean equal(int[] first, int[] second) {
        List<Integer> firstList = Arrays.stream(first).boxed().collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(second).boxed().collect(Collectors.toList());
        return ListUtil.equalV2(firstList, secondList);
    }
}

package com.fullofinspiration.github.util;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import javax.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.*;

public class ListUtil {
    private static final String MSG_FORMAT = "Exists only in one side: %s, first: %s, second: %s";

    public static <T> boolean equalV2(@Nullable List<T> first, @Nullable List<T> second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
        if (first.size() != second.size()) {
            String msg = String.format("first size: %s is not equal to second size: %s, first: %s, second: %s",
                    first.size(), second.size(), first, second);
            System.out.println(msg);
            return false;
        }
        for (int i = 0; i < first.size(); i++) {
            if (!Objects.equals(first.get(i), second.get(i))) {
                String msg = String.format("idx: %s first val: %s is not equal to second val: %s, first: %s, second: %s",
                        i, first.get(i), second.get(i), first, second);
                System.out.println(msg);
                return false;
            }
        }
        return true;
    }

    public static <T> boolean equal(@Nullable List<T> first, @Nullable List<T> second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }
        HashSet<T> firstSet = new HashSet<>(first);
        HashSet<T> secondSet = new HashSet<>(second);
        return isSecondContainAllFirst(firstSet, secondSet) && isSecondContainAllFirst(secondSet, firstSet);

    }

    private static <T> boolean isSecondContainAllFirst(HashSet<T> firstSet, HashSet<T> secondSet) {
        ImmutableSet<T> existsOnlyInLeft = Sets.difference(firstSet, secondSet).immutableCopy();
        if (!existsOnlyInLeft.isEmpty()) {
            String msg = String.format(MSG_FORMAT, existsOnlyInLeft, firstSet, secondSet);
            System.out.println(msg);
            return false;
        }
        return true;
    }

}

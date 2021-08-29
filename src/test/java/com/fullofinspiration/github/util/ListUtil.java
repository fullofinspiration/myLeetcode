package com.fullofinspiration.github.util;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.sun.istack.internal.Nullable;

import java.util.HashSet;
import java.util.List;

public class ListUtil {
    private static final String MSG_FORMAT = "Exists only in one side: %s, first: %s, second: %s";

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

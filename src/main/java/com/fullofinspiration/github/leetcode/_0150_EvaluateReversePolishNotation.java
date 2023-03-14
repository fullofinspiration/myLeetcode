package com.fullofinspiration.github.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _0150_EvaluateReversePolishNotation {
    /**
     * https://leetcode.com/problems/evaluate-reverse-polish-notation/solutions/47430/java-accepted-code-stack-implementation/?orderBy=most_votes
     */
    class Solution {
        public int evalRPN(String[] tokens) {
            LinkedList<Integer> all = new LinkedList<>();
            for (int i = 0; i < tokens.length; i++) {
                String curVal = tokens[i];
                if ("+".equals(curVal)) {
                    all.push(all.pop() + all.pop());
                } else if ("-".equals(curVal)) {
                    int second = all.pop();
                    int first = all.pop();
                    all.push(first - second);
                } else if ("*".equals(curVal)) {
                    all.push(all.pop() * all.pop());
                } else if ("/".equals(curVal)) {
                    int second = all.pop();
                    int first = all.pop();
                    all.push(first / second);
                } else {
                    all.push(Integer.parseInt(curVal));
                }
            }
            return all.pop();
        }
    }

    /**
     * 写起来太繁琐了，没有必要新建一个枚举类
     */
    class Solution00 {
        public int evalRPN(String[] tokens) {
            LinkedList<String> all = new LinkedList<>();
            for (int i = 0; i < tokens.length; i++) {
                String curVal = tokens[i];
                check(curVal);
                if (!Operator.isOperation(curVal)) {
                    all.push(curVal);
                    continue;
                }
                if (all.size() < 2) {
                    throw new IllegalStateException();
                }
                int secondVal = Integer.parseInt(all.pop());
                int firstVal = Integer.parseInt(all.pop());
                int curRst = operate(firstVal, secondVal, Operator.convert(curVal));
                all.push(String.valueOf(curRst));
            }
            if (all.size() != 1) {
                throw new IllegalStateException();
            }
            return Integer.parseInt(all.pop());
        }

        private void check(String s) {
            if (Operator.isOperation(s)) {
                return;
            }
            Integer.parseInt(s);
        }

        private int operate(int first, int sec, Operator operator) {
            switch (operator) {
                case PLUS:
                    return first + sec;
                case MINUS:
                    return first - sec;
                case MULTI:
                    return first * sec;
                case DIVIDE:
                    return first / sec;
                default:
                    throw new IllegalStateException();
            }
        }

    }

    private enum Operator {
        PLUS("+"),
        MINUS("-"),
        MULTI("*"),
        DIVIDE("/"),
        ;
        private String flag;
        private static Map<String, Operator> ALL_FLAGS = Arrays.stream(Operator.values()).collect(Collectors.toMap(a -> a.flag, Function.identity()));

        Operator(String flag) {
            this.flag = flag;
        }

        private static boolean isOperation(String s) {
            return ALL_FLAGS.containsKey(s);
        }

        private static Operator convert(String s) {
            if (!isOperation(s)) {
                throw new IllegalStateException();
            }
            return ALL_FLAGS.get(s);
        }
    }
}

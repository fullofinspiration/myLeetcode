package com.fullofinspiration.github.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class _0155_MinStack {
    class MinStack {
        private Deque<Integer> valStack;
        private Deque<Integer> minStack;

        public MinStack() {
            valStack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            valStack.push(val);
            minStack.push(Math.min(val, minStack.peek()));
        }

        public void pop() {
            valStack.pop();
            minStack.pop();

        }

        public int top() {
            return valStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    class MinStack00 {
        private final LinkedList<Node> all;

        /**
         * initialize your data structure here.
         */
        public MinStack00() {
            all = new LinkedList<>();
        }

        public void push(int val) {
            if (all.isEmpty()) {
                all.push(new Node(val, val));
            } else {
                all.push(new Node(val, Math.min(getMin(), val)));
            }
        }

        public void pop() {
            all.pop();
        }

        public int top() {
            return all.peek().val;
        }

        public int getMin() {
            return all.peek().minValue;
        }

        private class Node {
            private int val;
            private int minValue;

            private Node(int val, int minValue) {
                this.val = val;
                this.minValue = minValue;
            }
        }
    }
}

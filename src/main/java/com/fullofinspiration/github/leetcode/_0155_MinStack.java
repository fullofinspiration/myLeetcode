package com.fullofinspiration.github.leetcode;

import java.util.LinkedList;

public class _0155_MinStack {
    class MinStack {
        private final LinkedList<Node> all;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
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

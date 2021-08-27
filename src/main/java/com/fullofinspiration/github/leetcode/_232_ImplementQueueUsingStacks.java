package com.fullofinspiration.github.leetcode;

import java.util.LinkedList;

public class _232_ImplementQueueUsingStacks {
    class MyQueue {

        private final LinkedList<Integer> first;
        private final LinkedList<Integer> second;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            first = new LinkedList<>();
            second = new LinkedList<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            first.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (!second.isEmpty()) {
                return second.pop();
            }
            if (first.isEmpty()) {
                throw new IllegalStateException();
            }
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
            return second.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!second.isEmpty()) {
                return second.peek();
            }
            if (first.isEmpty()) {
                return -1;
            }
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
            return second.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return first.isEmpty() && second.isEmpty();
        }
    }
}

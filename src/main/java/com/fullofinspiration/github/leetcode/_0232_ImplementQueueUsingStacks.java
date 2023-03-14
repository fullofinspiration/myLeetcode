package com.fullofinspiration.github.leetcode;

import java.util.*;

public class _0232_ImplementQueueUsingStacks {
    /**
     * 1 两个栈，每次入队，直接入左边的栈
     * 2 出队，如果有则直接返回，如果没有则将所有数字倒腾到右栈
     * 3 peek 和出队类似
     * 错误原因：peek时判断两个队列都为empty才抛出空指针
     */
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
            if (first.isEmpty() && second.isEmpty()) {
                throw new IllegalStateException();
            }
            if (!second.isEmpty()) {
                return second.pop();
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
            if (first.isEmpty() && second.isEmpty()) {
                throw new IllegalStateException();
            }
            if (!second.isEmpty()) {
                return second.peek();
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

    class MyQueue00 {


        private final LinkedList<Integer> first;
        private final LinkedList<Integer> second;

        /**
         * Initialize your data structure here.
         */
        public MyQueue00() {
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

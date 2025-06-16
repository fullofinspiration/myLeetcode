package com.fullofinspiration.github.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _0295_MediumFinder {
    class MedianFinder {
        private final PriorityQueue<Integer> minQueue;
        private final PriorityQueue<Integer> maxQueue;

        public MedianFinder() {
            minQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
            maxQueue = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            if (maxQueue.isEmpty()) {
                maxQueue.offer(num);
                return;
            }
            if (maxQueue.peek() > num) {
                maxQueue.offer(num);
                if (maxQueue.size() > minQueue.size() + 1) {
                    minQueue.offer(maxQueue.poll());
                }
                return;
            }
            minQueue.offer(num);
            if (minQueue.size() > maxQueue.size()) {
                maxQueue.offer(minQueue.poll());
            }
        }

        public double findMedian() {
            if (maxQueue.size() == 0 && minQueue.size() == 0) {
                return 0;
            }
            if ((maxQueue.size() + minQueue.size()) % 2 == 1) {

                return maxQueue.peek();
            }
            return (double) ((maxQueue.peek() + minQueue.peek())) / 2;
        }
    }
}

package com.fullofinspiration.github.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhenpeng Zhang on 2021/1/18.
 */
public class _0057_InsertInterval {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        Interval interval = new Interval();
        interval.start = 1;
        interval.end = 3;
        intervals.add(interval);

        Interval interval1 = new Interval();
        interval1.start = 6;
        interval1.end = 9;
        intervals.add(interval1);

        Interval interval2 = new Interval();
        interval2.start = 2;
        interval2.end = 5;

        Solution solution = new Solution();
        List<Interval> insert = solution.insert(intervals, interval2);
        System.out.println(insert);

    }

    static class Solution {

        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            int start = newInterval.start;
            int end = newInterval.end;
            int index = 0;
            List<Interval> result = new ArrayList<>();

            while (index < intervals.size() && intervals.get(index).end < start) {
                result.add(intervals.get(index));
                index++;
            }
            while (index < intervals.size() && intervals.get(index).start <= end) {
                start = Math.min(start, intervals.get(index).start);
                end = Math.max(end, intervals.get(index).end);
                index++;
            }

            Interval interval = new Interval();
            interval.start = start;
            interval.end = end;
            result.add(interval);

            while (index < intervals.size()) {
                result.add(intervals.get(index));
                index++;
            }
            return result;
        }


    }

    public static class Interval {

        int start;

        int end;

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}

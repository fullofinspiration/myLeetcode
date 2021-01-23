package com.fullofinspiration.github.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Interval {
  public int getStart() {
    return start;
  }
  int start;
  int end;

  public Interval() {
    start = 0;
    end = 0;
  }

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}

public class MergeIntervals {

  public static List<Interval> merge(List<Interval> intervals) {

    intervals.sort(new Comparator<Interval>() {
      @Override
      public int compare(Interval o1, Interval o2) {
        return o1.start - o2.start;
      }
    });
    LinkedList<Interval> list = new LinkedList<>();
    for (Interval interval:intervals) {
      if (list.size()==0 || list.getLast().end < interval.start) {
        list.add(interval);
      } else {
        list.getLast().end = Math.max(list.getLast().end,interval.end);
      }
    }
    return list;
  }
}

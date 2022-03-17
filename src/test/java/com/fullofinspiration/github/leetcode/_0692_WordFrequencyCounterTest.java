package com.fullofinspiration.github.leetcode;

import com.fullofinspiration.github.leetcode._0692_WordFrequencyCounter.Solution;
import com.fullofinspiration.github.util.ListUtil;
import com.google.common.collect.ImmutableList;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zhang.zhenpeng_203631@immomo.com
 * @date 2022/1/28 11:05 AM
 */
public class _0692_WordFrequencyCounterTest extends TestCase {

  private static final Solution SOLUTION = new _0692_WordFrequencyCounter().new Solution();

  @Test
  public void test00() {
    String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
    List<String> rst = SOLUTION.topKFrequent(input, 2);
    List<String> expect = ImmutableList.of("i", "love");
    boolean equal = ListUtil.equal(expect, rst);
    Assert.assertTrue(equal);
  }

  @Test
  public void test01() {
    String[] input = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
    List<String> rst = SOLUTION.topKFrequent(input, 4);
    List<String> expect = ImmutableList.of("the", "is", "sunny", "day");
    boolean equal = ListUtil.equal(expect, rst);
    Assert.assertTrue(equal);
  }

  @Test
  public void test03() {
    String a = "i";
    String b = "love";
    System.out.println(a.compareTo(b));
  }

}
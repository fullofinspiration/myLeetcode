package com.fullofinspiration.github.leetcode;

import java.util.*;
import java.util.function.Function;


public class _0347_TopKFrequentElements {

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> value2Count = new HashMap<>();
            for (int num : nums) {
                value2Count.put(num, value2Count.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            for (Map.Entry<Integer, Integer> entry : value2Count.entrySet()) {
                Integer value = entry.getKey();
                Integer count = entry.getValue();
                if (queue.size() < k) {
                    queue.offer(new int[]{value, count});
                    continue;
                }
                int[] peek = queue.peek();
                if (peek[1] < count) {
                    queue.offer(new int[]{value, count});
                    queue.poll();
                }
            }
            int[] ret = new int[queue.size()];
            for (int i = 0; i < ret.length; i++) {
                ret[i] = queue.poll()[0];
            }
            return ret;
        }
    }

    /**
     * https://leetcode.com/problems/top-k-frequent-elements/solutions/?orderBy=most_votes
     * 1 新建key2freq
     * 2 用bucket sort，idx代表freq，value为list
     * 3 从大到小，如果超过最大长度，则返回结果
     */
    class Solution01 {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> key2Freq = new HashMap<>();
            for (int num : nums) {
                int freq = key2Freq.getOrDefault(num, 0);
                key2Freq.put(num, freq + 1);
            }
            List<Integer>[] values = (List<Integer>[]) new List[nums.length];
            for (int key : key2Freq.keySet()) {
                int freq = key2Freq.get(key);
                List<Integer> value = values[freq - 1];
                if (value == null) {
                    value = new ArrayList<>();
                }
                value.add(key);
                values[freq - 1] = value;
            }
            List<Integer> rst = new ArrayList<>();
            for (int i = values.length - 1; i >= 0 && rst.size() < k; i--) {
                if (values[i] == null) {
                    continue;
                }
                rst.addAll(values[i]);
            }
            return rst.stream().mapToInt(a -> a).toArray();
        }
    }

    /**
     * 1 收集每个元素出现个数（hashmap or arr, 由于10^-4<nums<10^4, 也可以用arr，但是有点浪费内存）
     * 2 写frequency2Eles的hash（这里有个漏洞，frequency有可能对应多个ele），所以value是一个list
     * 3 新建队列
     * 4 每次插入时，1）根据队列长度，遍历队列，都出对，然后每个都和当前元素对比，如果比他小，则替换掉
     * <p>
     * 遍历到最后一个节点时只出对不入队
     * 时间复杂度：遍历 O(1) ，每次插入n^2 故时间复杂度是O(n^2)
     * 空间复杂度 两个hashmap 2n， 新建队列n 总的空间复杂度O(n)
     * 疑问：这个算法题是糅合了统计数量+top n， 我不知道出这道题的目的，是为了一道题当两道题用吗
     * 出现问题1 ：idea发现的，遍历队列元素时，应该在循环里面假如prevLength，如果在循环外边，队列元素永远是初始值0，因为变量太多，导致大脑很混乱
     * 2 判断是否添加进当前元素时，应该判断当前队列长度，而不是之前缓存到prevLength的值，因为这个值已经被改成0了
     * 3 最终的结果应该是真实的value值，而不是frequency的值，忘记返回影射值了
     * 4 frequency对应的value值可能是多个，所以value是list
     * 5 后面改了bug 10余个
     * <p>
     * 用队列排序topn太复杂，这道题在git book 2022秋招高频面试中又归在队列下边，导致浪费大量时间，最简单应该是堆排序，或者使用bucket sort
     */
    class Solution00 {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> num2Frequency = new HashMap<>();
            for (int num : nums) {
                int frequency = num2Frequency.getOrDefault(num, 0);
                num2Frequency.put(num, frequency + 1);
            }
            Map<Integer, List<Integer>> frequency2Num = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : num2Frequency.entrySet()) {
                List<Integer> value = frequency2Num.getOrDefault(entry.getValue(), new ArrayList<Integer>());
                value.add(entry.getKey());
                frequency2Num.put(entry.getValue(), value);
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int num : frequency2Num.keySet()) {
                int count = frequency2Num.get(num).size();
                while (count-- > 0) {
                    int curNum = num;
                    int prevSize = queue.size();
                    while (prevSize-- > 0) {
                        Integer head = queue.remove();
                        queue.add(Math.max(head, curNum));
                        curNum = Math.min(head, curNum);
                    }
                    if (queue.size() < k) {
                        queue.add(curNum);
                    }
                }

            }
            List<Integer> rst = new ArrayList<>();
            int prev = -1;
            while (!queue.isEmpty()) {
                int cur = queue.remove();
                if (cur == prev) {
                    continue;
                }
                rst.addAll(frequency2Num.get(cur));
                prev = cur;
            }
            return rst.stream().mapToInt(i -> i).toArray();
        }
    }
}

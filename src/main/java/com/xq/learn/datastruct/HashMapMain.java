package com.xq.learn.datastruct;

import java.util.HashMap;
import java.util.Map;

/**
 * Map，Set
 * 根据底层的实现不同，分为HashMap和TreeMap，前者是基于hash表实现，后者是二叉树实现
 * TreeMap中的元素是有序的，时间复杂度是O(logn)
 * HashMap的平均时间复杂度是O(1), 最坏的时间复杂度是O(n)
 * @author xiaoqiang
 * @date 2020/3/26 16:46
 */
public class HashMapMain
{
    public static void main(String[] args)
    {
        System.out.println(isAnagram("abca", "acba"));
    }
    /**
     * 校验异位词: 统计每一个词出现的次数
     * LeetCode: 242
     * @param s s
     * @param t t
     * @return 是否是异位词
     */
    public static boolean isAnagram(String s, String t)
    {
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();
        for (char ch : s.toCharArray())
        {
            sCount.compute(ch, (k, v) -> (null == v ? 0 : v) + 1);
        }

        for (char ch : t.toCharArray())
        {
            tCount.compute(ch, (k, v) -> (null == v ? 0 : v) + 1);
        }

        return sCount.equals(tCount);
    }
}

package com.xq.learn.datastruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        System.out.println(threeSum(new int[]{1, 0, 1, -2, -1, -4}));
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

    /**
     * 两个数的和：在数组中找到两个数的和为指定的目标值，返回对应的下标
     * LeetCode: 1
     * @param nums 数组元素
     * @param target 目标值
     * @return 对应元素的下标
     */
    public static int[] towSum(int[] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(target - nums[i]))
            {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 三数之和：给定一个数组，找出三个元素之和等于0的元素
     * LeetCode: 15
     * @param nums 数组
     * @return 和为0的三个元素
     */
    public static List<List<Integer>> threeSum(int[] nums)
    {
        Set<Integer> set = new HashSet<>();
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                if (set.contains(-nums[i] - nums[j]))
                {
                    result.add(Arrays.asList(-nums[i] - nums[j], nums[i], nums[j]));
                }
            }
            set.add(nums[i]);
        }

        return new ArrayList<>(result);
    }
}

package com.xq.learn.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 面试题
 * @author xiaoqiang
 * @date 2020/3/20 18:19
 */
public class Main
{
    public static void main(String[] args)
    {
        int[] result = twoSum(new int[]{1, 2, 3, 7, 9}, 9);
        System.out.println(Arrays.asList(12, 3));
        System.out.println("result: " + Arrays.asList(result));

        findTheDifference("addbcsed", "addbcfsed");

        // 0和x的亦或运算结果是x: 相同为0，不同为1，所以自己和自己亦或的结果为0，亦或运算满足结合律
        System.out.println(('a' ^ 'b') == ('b' ^ 'a'));

        System.out.println("进制转换：" + Integer.parseInt("101", 2));

        smallerNumbersThanCurrent(new int[]{8, 1, 2, 3, 5});

        // 链表
        List<String> list = new LinkedList<>();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        hasCycle(node);

        majorityElement(new int[]{1, 3, 3});
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
        {
            if (map.containsKey(target - nums[i]))
            {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }

        throw new IllegalStateException();
    }

    public static String reverseLeftWords(String s, int n) {
        return s = s.substring(n) + s.substring(0, n);
    }

    public int numberOfSteps (int num) {
        int steps = 0;
        while (true)
        {
            if (num == 0)
            {
                return steps;
            }
            if (num % 2 == 0)
            {
                num /= 2;
            }
            else
            {
                num -= 1;
            }
            steps += 1;
        }
    }

    public static char findTheDifference(String s, String t) {
        char[] chars = t.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++)
        {
            result ^= chars[i];
        }

        chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            result ^= chars[i];
        }
        return (char) result;
    }

    /**
     * 比当前元素小的元素个数
     * @param nums
     * @return
     */
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
        {
            int sum = 0;
            for (int j = 0; j < nums.length; j++)
            {
                if (j != i && nums[j] < nums[i])
                {
                    sum++;
                }
            }
            results[i] = sum;
        }
        return results;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next, slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public static ListNode linkedMiddle(ListNode head)
    {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null)
        {
            slow = head.next;
            fast = head.next.next;
        }
        return slow;
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (k, v) -> null == v ? 1 : ++v);
            if (map.get(num) > nums.length / 2)
            {
                return num;
            }
        }
        return 0;
    }
}

class ListNode
{
    int val;
    ListNode next;

    public ListNode(int val)
    {
        this.val = val;
        next = null;
    }
}

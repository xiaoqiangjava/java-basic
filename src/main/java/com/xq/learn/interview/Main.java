package com.xq.learn.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        System.out.println('Z' - 'z');
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

    public static String getResult() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] steps = line.split(";");
        String result = "(%s, %s)";
        Map<String, Integer> map = new HashMap<>();
        for (String step : steps) {
            if (isValid(step)) {
                int temp = Integer.parseInt(step.substring(1));
                map.compute(step.substring(0, 1), (k, v) -> null == v ? temp : v + temp);
            }
        }
        int x = 0, y = 0;
        for (String key : map.keySet()) {
            switch (key) {
                case "A":
                    x -= map.get("A");
                    break;
                case "D":
                    x += map.get("D");
                    break;
                case "W":
                    y += map.get("W");
                    break;
                case "S":
                    y -= map.get("S");
                    break;
                default:
                    break;
            }
        }
        return String.format(result, x, y);
    }

    private static boolean isValid(String input) {
        String regex = "^[ADWS]{1}(\\d){1,2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static void pwdValid() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (null == line || line.length() < 9) {
                System.out.println("NG");
                continue;
            }
            int[] category = new int[4];
            int sum = 0;
            for (char ch : line.toCharArray()) {
                if (ch >= '0' && ch <= '9') {
                    category[0] = 1;
                } else if (ch >= 'a' && ch <= 'z') {
                    category[1] = 1;
                } else if (ch >= 'A' && ch <= 'Z') {
                    category[2] = 1;
                } else {
                    category[3] = 1;
                }
                sum = category[0] + category[1] + category[2] + category[3];
                if (sum >= 3) {
                    break;
                }
            }
            if (sum < 3) {
                System.out.println("NG");
            } else {
                System.out.println(hasSubString(line));
            }

        }
    }

    private static String hasSubString(String line) {
        for (int i = 0; i < line.length() - 3; i++) {
            String sub = line.substring(i, i + 3);
            if (line.substring(i + 3).contains(sub)) {
                return "NG";
            }
        }
        return "OK";
    }

    public static void simplePwd() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            StringBuilder builder = new StringBuilder();
            for (char ch : line.toCharArray()) {
                builder.append(alphaTrans(ch));
            }
            System.out.println(builder.toString());
        }
    }

    private static char alphaTrans(char ch) {
        // 'Z'特殊处理为a
        if (ch == 'Z') {
            return  'a';
        }
        if (ch >= 'A' && ch < 'Z') {
            ch = (char) (ch + 32);
            return ++ch;
        }
        int[] charTable = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9};
        if (ch >= 'a' && ch <= 'z') {
            return (char) (charTable[ch - 'a'] + '0');
        }

        return ch;
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

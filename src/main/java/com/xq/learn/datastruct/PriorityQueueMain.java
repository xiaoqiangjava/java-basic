package com.xq.learn.datastruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 优先队列：
 * 正常入队，优先出队
 * 优先级是优先级队列本身的一个属性，可以设置最小的先出队，也可以设置最大的先出队，或者是按照次数出队，都可以设置
 * @author xiaoqiang
 * @date 2020/3/25 17:12
 */
public class PriorityQueueMain
{
    public static void main(String[] args)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        pq.offer(1);
        pq.offer(2);
        pq.offer(3);
        pq.offer(4);
        while (!pq.isEmpty())
        {
            pq.poll();
        }
        int[] nums = new int[]{7, 2, 4};
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println(kthLargest.add(9));

        int[] maxs = maxSlidingWindow(nums, 2);
        System.out.println(maxs);
    }

    /**
     * Sliding window maximum
     * LeetCode: 239
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     * @param nums 给定的数组
     * @param k window窗口的大小
     * @return 最大的元素
     */
    public static int[] maxSlidingWindow(int[] nums, int k)
    {
        // 校验参数
        if (null == nums || nums.length == 0)
        {
            return new int[0];
        }
        // 创建优先级队列，用作固定长度的窗口
        PriorityQueue<Integer> window = new PriorityQueue<>(k, (x, y) -> y - x);
        int[] res = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (i >= k)
            {
                window.remove(nums[i - k]);
            }
            window.offer(nums[i]);
            if (i >= k - 1)
            {
                res[idx] = window.peek();
                idx++;
            }
        }

        return res;
    }

}

/**
 * 数据流中的第K大元素
 * LeetCode: 703
 * @return 第k大元素
 */
class KthLargest
{
    private PriorityQueue<Integer> priorityQueue;

    private int k;

    public KthLargest(int k, int[] nums)
    {
        this.k = k;
        priorityQueue = new PriorityQueue<>(k);
        for (int num : nums)
        {
            add(num);
        }
    }

    public int add(int x)
    {
        if (priorityQueue.size() >= k)
        {
            if (x > priorityQueue.peek())
            {
                priorityQueue.poll();
                priorityQueue.offer(x);
            }
        }
        else
        {
            priorityQueue.offer(x);
        }

        return priorityQueue.peek();
    }
}

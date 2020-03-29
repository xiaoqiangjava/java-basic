package com.xq.learn.algorithm;

/**
 * 二分查找：常用于在数组中查找一个元素
 * 二分超找的要求：
 * 1. 该数组必须是排序了的（递增或者递减）  Sorted
 * 2. 该数组存在上下界  Bounded
 * 3. 可以通过索引访问  Accessible by index
 * @author xiaoqiang
 * @date 2020/3/29 14:47
 */
public class BianrySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 9, 11};
        System.out.println(binarySearch(nums, 0));
        System.out.println(sqrt(9));
    }
    /**
     * 二分查找模板
     * @param nums 递增排序了的数组
     * @param target 需要找的目标元素
     * @return target index
     */
    private static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            // 判断当前元素是否是target，如果是，返回下标
            if (nums[mid] == target) {
                return mid;
            }
            // 如果当前元素大于target,从右边开始找
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 不存在该元素
        return -1;
    }

    /**
     * 求x的平方根，即y = x * x, 给定y，求x，因为该函数时单调递增的函数，因此可以使用二分查找法
     * LeetCode: 69
     * @param x x
     * @return sqrt
     */
    public static int sqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1, right = x >> 1; // x的平方根肯定小于x，所以右界定为x
        int res = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            // 这种处理方法放着x*x超出int的范围
            if (mid == x / mid) {
                return mid;
            }
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = left + 1;
            }
            res = mid;
        }
        return res;
    }
}

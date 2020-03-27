package com.xq.learn.algorithm;

/**
 * 分治算法：将问题拆分成两个相同或者相似的子问题，再把子问题拆分成更小的子问题，直到最后问题可以简单的求解，原问题的解即
 * 子问题的解的合并。
 * 分治算法解决问题一般具有下面4个特征：
 * 1. 该问题的规模缩小到一定的程度就可以很容易的解决。
 * 2. 该问题可以分解为若干个规模较小的相同问题，即该问题具有最优子结构性质。
 * 3. 利用该问题分解出来的子问题的解可以合并为该问题的解。 （能否使用Divide & Conquer的关键）
 * 4. 该问题分解出来的各个子问题的解是相互独立的，即子问题之间不包括公共的子子问题。  （影响Divide & Conquer的效率）
 * @author xiaoqiang
 * @date 2020/3/27 23:04
 */
public class DivideAndConquer
{
    public static void main(String[] args)
    {
        System.out.println(myPow(2, 10000000));
    }
    /**
     * 求解x的n次方
     * LeetCode: 50
     * pow(x, y) 库函数
     * 暴力解法直接循环n次，时间复杂度为O(n)
     * 使用Divide & Conquer 分解为x的n/2，n/4... 时间复杂度为O(logn)
     * @param x x
     * @param n n
     * @return pow
     */
    public static Double myPow(double x, int n)
    {
        if (n == Integer.MIN_VALUE && x > 1)
        {
            return 0.0;
        }
        if (n == 0)
        {
            return 1.0;
        }
        boolean flag = n > 0;
        n = n < 0 ? -n : n;
        double res = myPow(x * x, n / 2);
        if ((n & 1) != 0)
        {
            res = x * res;
        }

        return flag ? res : 1 / res;
    }
}

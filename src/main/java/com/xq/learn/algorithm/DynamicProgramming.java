package com.xq.learn.algorithm;

/**
 * Dynamic Programming 动态规划，动态递推
 * 1. 递归 + 记忆化  --> 递推
 * 2. 状态定义：opt[n], dp[n], fib[n]
 * 3. 状态转移方程：opt[n] = best_of(opt(n - 1), opt(n - 2,...)
 * 4. 最优子结构，即前面n-1种子结构可以推导出一个最优的解。
 *
 * DP vs Recursion vs Greedy
 * 递归：重复计算，没有最优子结构时，只能重复计算。
 * 贪心：永远局部最优，如果局部最优可以推导到全局最优的话，可以使用贪心。
 * 动态规划：记录局部最优子结构/多种记录值，即集递归和贪心两者的优点，通过记录局部最优解，通过动态转移方程求全局的最优解。
 * @author xiaoqiang
 * @date 2020/3/30 22:22
 */
public class DynamicProgramming {
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 20;
//        int fib = fib(n);
        System.out.println("fib: " + (System.nanoTime() - start));
        start = System.nanoTime();
        int fib_1 = fib_1(n, new int[n + 1]);
        System.out.println("fib_1: " + (System.nanoTime() - start));
        System.out.println(fib_1);
        System.out.println(fib_2(n));
    }
    /**
     * 常见的斐波那契数列：0 1 1 2 3 5 8 13 21 34...
     * 递推公式：f[n] = f[n-1] + f[n - 2]
     * 第一种解法：使用Recursion，时间复杂度为O(2**n), 该解法存在问题就是重复计算，即在计算f[n - 1] + f[n - 2]的值时，会存在多次重复的值
     * @param n n
     * @return 第n个数的值
     */
    private static int fib(int n) {
        // 1. 终止条件
        if (n <= 1) {
            return n;
        }
        // 2. 递归调用并求解当前n对应的值，然后将当前临时结果返回
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 斐波那契队列的第二种解法，可以将已经计算过的值存入缓存，下次直接从缓存里面拿
     * 这样的话该种算法可以将时间复杂度优化到O(n)，速度提高很多，但是空间复杂度为O(n)
     * @param n n
     * @param memo 缓存
     * @return 第n个数的值
     */
    private static int fib_1(int n, int[] memo) {
        // 1. 终止条件
        if (n <= 1) {
            return n;
        }
        // 2. 递归调用，然后将中间结果存入缓存，在进入下一层递归时防止重复计算
        if (memo[n] == 0) {
            int temp = fib_1(n - 1, memo) + fib_1(n - 2, memo);
            memo[n] = temp;
        }
        return memo[n];
    }

    /**
     * 斐波那契队列第三种解法：Dynamic Programming
     * 由fib_1得到的结果可知，可以通过递推的方式，从下往上递推求出n的结果
     * 递推公式：f[n] = f[n-1] + f[n-2]
     * 该解法的时间复杂度为O(n), 与第二种解法的区别就是不需要额外的空间来存放中间的计算结果
     * @param n n
     * @return 第n个数的值
     */
    private static int fib_2(int n) {
        if (n < 2) {
            return n;
        }
        int temp = 0;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            int val = temp + res;
            temp = res;
            res = val;
        }
        return res;
    }
}

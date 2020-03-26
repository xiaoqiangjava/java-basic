package com.xq.learn.operation;

import javax.sound.midi.Soundbank;

/**
 * java 中的位运算符:<< >> & | ! ^
 * <<: 左移，常用来乘以2的n次方时使用。
 * >>: 右移，常用来做除以2的n次方运算。
 * &: 与运算，只有两个操作数中位都是1则为1，否则为0. 即都是1时才为1
 * |: 或运算，两个操作数中位有一个为1则为1，否则为0. 即都是0时才为0
 * ~: 非运算，如果位为1，则结果是0，若位为0，则结果为1. 即1变0，0变1
 * ^: 亦或运算，两个操作数中位相同则为0，不同则为1.
 * @author xiaoqiang
 * @date 2020/3/21 13:32
 */
public class BitOperation
{
    public static void main(String[] args)
    {
        // 移位运算
        System.out.println(6 << 3); // 80  5 * 2**4
        System.out.println(20 >> 1); // 12  20 / 2
        System.out.println(20 >> 2); // 12  20 / 2 / 2
        System.out.println(20 >> 3); // 12  20 / 2 / 2 / 2   由于是用0补齐，因此奇数会变成小于它的偶数, 然后再除2
        System.out.println(30 >> 3); // 1

        // & 运算: 判断一个数是奇数还是偶数
        int x = 4;
        System.out.println(x & 1); // x & 1 == 0表示偶数，x & 1 == 1表示奇数

        // ^ 运算：x ^ x = 0; x ^ 0 = x; x ^ y ^ z = x ^ (y ^ z)
        System.out.println(5 ^ 5); // 0
        System.out.println(0 ^ 5); // 5
        System.out.println(5 ^ 6 ^ 7);
        System.out.println(7 ^ 5 ^ 6);
    }
}

package com.ylb.array;

/**
 * 数组：实现整数的数字反转
 */
public class ReverseInteger {

    public static int reverse(int x) {
        if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
            // 整数类型的最小值的绝对值 比 最大值的绝对值 大1
            return 0;
        }
        int sign = x > 0 ? 1 : -1; // 符号
         x = x < 0 ? -x : x; // 无论正负，都当成正数
        // 1.整数转字符串，再转字符数组
         String str = String.valueOf(x);
         char[] chars = str.toCharArray();
        // 2.反向遍历字符数组，并将元素存储到新数组中
        int len = chars.length;
        char[] array = new char[len];
        for (int i = 0; i < len; i++) {// 遍历新数组
            array[i] = chars[len - 1 - i];
        }
        // 3.将新数组转成字符串，再转成整数输出
        long value = Long.valueOf(String.valueOf(array));
        boolean b = value > Integer.MAX_VALUE || value < Integer.MIN_VALUE;
        int result = b ? 0 : (int)value; // 数值越界：溢出则返回0
        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123456));
    }

}

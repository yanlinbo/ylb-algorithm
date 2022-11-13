package com.ylb.array;

import java.util.Arrays;

/**
 * 寻找数组中心下标
 */
public class ArrayCenterIndex {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
    }

    private static int pivotIndex(int[] ints) {

        int num = Arrays.stream(ints).sum();
        int total = 0;
        for (int i = 0; i < ints.length; i++) {
            total+=ints[i];
            if(total == num){
                return i;
            }
            num-=ints[i];
        }
        return 0;
    }
}

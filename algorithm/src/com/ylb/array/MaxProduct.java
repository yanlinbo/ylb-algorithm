package com.ylb.array;

import java.util.Arrays;

public class MaxProduct {

    public static void main(String[] args) {
        System.out.println(sort(new int[]{-1,-3,8,2,4,5,6}));

        System.out.println(getMaxMin(new int[]{-1,-3,8,2,4,5,6}));
    }

    private static int getMaxMin(int[] ints) {

        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int x : ints){
            if(x < min1){
                min2 = min1;
                min1 = x;
            }else if(x < min2){
                min2 = x;
            }

            if(x > max1){
                max3 = max2;
                max2 = max1;
                max1 = x;
            }else if(x > max2){
                max3 = max2;
                max2 = x;
            }else if(x > max3){
                max3 = x;
            }
        }
        return Math.max(min1*min2*max1,max1*max2*max3);
    }

    private static int sort(int[] ints) {
        Arrays.sort(ints);
        int n = ints.length;
        return Math.max(ints[0]*ints[1]*ints[n-1],ints[n-1]*ints[n-2]*ints[n-3]);

    }
}

package com.ylb.array;

/**
 * 删除排序数组中的重复项
 */
public class SortedArrayDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDumplicates(new int[]{0,1,2,2,3,3,4}));
    }

    /**
     * 双指针算法
     * @param ints
     * @return
     */
    private static int removeDumplicates(int[] ints) {
        if(ints.length==0){
            return 0;
        }
        int i=0;
        for (int j = 1; j < ints.length; j++) {
            if(ints[i] != ints[j]){
                i++;
                ints[i] = ints[j];
            }
        }
        for (int n = 0; n < ints.length; n++) {
            System.out.println(ints[n]);
        }

        return i;
    }
}

package com.ylb.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 求数组中两个数之和为目标值
 */
public class TwoNumSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,5,6},10)));

        System.out.println(Arrays.toString(solution01(new int[]{1,2,3,4,5,6},10)));

        System.out.println(Arrays.toString(solutionNew(new int[]{1,2,3,4,5,6},10)));
    }

    /**
     * 暴力算法
     * @param ints
     * @param i
     * @return
     */
    private static int[] solution(int[] ints, int i) {

        for (int j = 0; j < ints.length; j++) {
            for (int k = 1; k < ints.length; k++) {
                if(ints[j] + ints[k] == i){
                    return new int[]{j,k};
                }
            }
        }

        return new int[0];
    }

    /**
     * 暴力算法优化
     * @param ints
     * @param target
     * @return
     */
    private static int[] solution01(int[] ints, int target) {

        for (int j = 0; j < ints.length; j++) {
            for (int k = j+1; k < ints.length; k++) {
                if(ints[j] + ints[k] == target){
                    return new int[]{j,k};
                }
            }
        }

        return new int[0];
    }

    /**
     * 便捷算法
     * @param ints
     * @param target
     * @return
     */
    private static int[] solutionNew(int[] ints, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int j = 0; j < ints.length; j++) {
            if(map.containsKey(target-ints[j])){
                return  new int[]{map.get(target-ints[j]),j};
            }
            //注意这里别写错了
            map.put(ints[j],j);
        }

        return new int[0];
    }
}

package com.ylb;

/**
 * x的平方根
 */
public class SqrtX {

    public static void main(String[] args) {
        System.out.println(binarySearch(24));

        System.out.println(newton(25));
    }

    /**
     * 牛顿迭代
     * @param x
     * @return
     */
    private static int newton(int x) {

        return -1;
    }

    /**
     * 二分法
     * @param x
     * @return
     */
    private static int binarySearch(int x) {
        int index = -1, l = 0, r = x;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(mid * mid <= x){
                index = mid;
                l = mid + 1;
            }else{
                r = mid -1;
            }
        }

        return index;
    }
}

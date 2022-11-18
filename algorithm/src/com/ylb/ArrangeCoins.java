package com.ylb;

public class ArrangeCoins {

    public static void main(String[] args) {
        System.out.println(arrangeCoins(10));

        System.out.println(arrangeCoins2(10));

        System.out.println(arrangeCoins3(10));
    }

    /**
     * 暴力算法
     * @param n
     * @return
     */
    private static int arrangeCoins(int n) {
        for (int j = 0; j <= n; j++) {
            n = n - j;
            if(n <= j){
                return j;
            }
        }
        return 0;
    }

    /**
     * 二分查找
     * @param n
     * @return
     */
    private static int arrangeCoins2(int n) {
        int low  = 0,high = n;
        while(low <= high){
            int mid = (low + high)/2;
            int cost = (1+mid)*mid/2;
            if(cost == n){
                return mid;
            }else if(cost < n){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return high;
    }

    /**
     * 牛顿迭代
     * @param n
     * @return
     */
    private static int arrangeCoins3(int n) {
        if(n == 0){
           return 0;
        }
        return (int)sqrt(n,n);
    }

    private static double sqrt(double x, int n) {
        double res = (x + (2*n-x)/x)/2;
        if(res == x){
            return x;
        }else{
            return sqrt(res, n);
        }
    }
}

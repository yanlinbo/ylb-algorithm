package com.ylb;

public class Sushu {

    public static void main(String[] args) {
        System.out.println(blsf(100));

        System.out.println(asf(100));
    }

    /**
     * 暴力算法
     * @param n
     * @return
     */
    public static int blsf(int n){
        int count = 0;
        for(int i=2;i<n;i++){
            count += isPrime(i) ? 1:0;
        }
        return count;
    }

    private static boolean isPrime(int x) {
        //todo:为什么把j<x结果是25，而换成j*j<x结果就成了29？  答案：需要把j*j<x改成j*j<=x
        for (int j = 2; j*j <= x; j++) {
            if(x%j == 0){
                return false;
            }
        }
        return  true;
    }

    /**
     * 埃筛法
     * @param n
     * @return
     */
    public static int asf(int n){
        Boolean[] isPrime = new Boolean[n];
        //todo 先给数组赋值
        for (int i = 0; i < 100; i++) {
            isPrime[i] = false;
        }
        int count = 0;
        for(int i=2;i<n;i++){
            if(!isPrime[i]){
                count++;
                //todo 这个条件可以改进，减少遍历的次数
                for(int j=2*i; j<n; j+=i){
                    isPrime[j] = true;
                }
                //改进后
//                for(int j=i*i; j<n; j+=i){
//                    isPrime[j] = true;
//                }
            }
        }
        return count;
    }
}

package com.shark.newcoder;

/**
 * Created by qinghualiu on 2017/3/19.
 * 如果更快的求一个整数k的n次方。如果两个整数相乘并得到结果的时间复杂度为O(1)，得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。

 给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。

 测试样例：
 2,3
 返回：8


 */
public class QuickPower {

    /**
     * 思路：
     *    k^N = k^(N/2) * k^(N/2) or k^N = k^((N-1)/2) * k^((N-1)/2) * k;
     *
     *
     * @param k
     * @param N
     * @return
     */
    public int getPower(int k, int N) {
        // write code here
        long result = -1;

        result = power(k, N);

        return (int)(result % 1000000007);
    }

    public long power(int k, int N){
        if(N == 1) return (long)k;
        if(N == 2) return (long)k*k;

        if(N % 2 == 0){
            return (power(k, N/2) * power(k, N/2)) % 1000000007;
        }else{
            return ((power(k, (N-1)/2) * power(k, (N-1)/2)%1000000007) * k) % 1000000007 ;
        }
    }

    public static void main(String[] args){
        QuickPower qp = new QuickPower();
        System.out.println(qp.getPower(2,3));
    }

}

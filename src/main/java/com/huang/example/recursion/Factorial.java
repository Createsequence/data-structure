package com.huang.example.recursion;

/**
 * @Author：黄成兴
 * @Date：2020-06-26 16:02
 * @Description：阶乘
 */
public class Factorial {

    public static void main(String[] args) {
        System.out.println(mult(5));
    }

    public static int mult(int n) {
        //当n=1时直接返回1
        if (n == 1){
            return n;
        }
        //计算n*(n-1)*(n-1-1).....
        return n * mult(n - 1);
    }

}

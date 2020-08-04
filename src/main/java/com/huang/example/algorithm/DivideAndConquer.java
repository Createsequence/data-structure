package com.huang.example.algorithm;

/**
 * @Author：CreateSequence
 * @Date：2020-07-28 17:29
 * @Description：分治算法解决汉诺塔问题
 */
public class DivideAndConquer {

    public static void main(String[] args) {
        char a = 'a';
        char b = 'b';
        char c = 'c';
        hanoiTower(3, a, b, c);
    }

    public static void hanoiTower(int num, char a, char b, char c) {
        //当盘子只有一个的时候
        if (num == 1) {
            System.out.println("第1个盘子从" + a + "==>" + c);
        }else {
            //将上面的盘子移动到b
            hanoiTower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘子从" + a + "==>" + c);
            //把所有盘子从b移动到c
            hanoiTower(num - 1, b, a, c);

        }
    }

}

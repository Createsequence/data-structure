package com.huang.example.recursion;

/**
 * @Author：黄成兴
 * @Date：2020-06-26 20:53
 * @Description：八皇后问题
 */
public class EightQueens {

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.set(0);
        System.out.println("共有摆法：" + eightQueens.count);
        System.out.println("判断次数：" + eightQueens.checkCount);
    }

    //记录八皇后有几种摆法
    int count = 0;

    //冲突次数
    int checkCount = 0;

    //表示皇后位置的数组
    int[] arr = new int[8];

    /**
     * 摆放皇后
     * @param n 第几个皇后
     */
    private void set(int n) {
        //如果放置好了第8个皇后
        if (n == 8){
            show();
            //记录一种摆放方式
            count++;
            //回到第一层继续递归
            return;
        }

        //遍历第n行的每一列
        for (int i = 0; i < 8; i++) {
            //将该皇后放置在第n行第i列
            arr[n] = i;
            //检查放置位置是否合适
            if (check(n)){
                //如果位置合适，就递归找下一个（n+1）皇后的摆放位置
                set(n + 1);
            }
            //如果位置不合适，就跳过这一列检查下一列
        }
    }

    /**
     * 展示某一摆法中八皇后的摆放位置
     */
    public void show() {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 检查第n个皇后是否与前面摆放的皇后冲突
     * @param n
     * @return
     */
    public boolean check(int n) {
        //计算共进行多少次判断
        checkCount++;

        //检查第n层之前的皇后位置
        for (int i = 0; i < n; i++) {
            // arr[i] == arr[n] 检查是否同一列
            // Math.abs(n - i) == Math.abs(arr[n] - arr[i]) 检查是否同一斜线
            if (arr[i] == arr[n] ||
                    Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}

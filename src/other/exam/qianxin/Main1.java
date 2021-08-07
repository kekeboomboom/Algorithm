package other.exam.qianxin;

import java.util.Scanner;

/**
 * @author keboom
 * @date 2021/8/7
 */
public class Main1 {

    int res = 0;

    public int TeamNums (int[] height) {
        // write code here
        process(height,0,0,-1);
        process2(height, 0, 0, -1);
        return res;
    }

    private void process(int[] height, int count, int index,int pre) {
        if (index == height.length) {
            return;
        }
        for (int i = index; i < height.length; i++) {
            if (count == 2 && height[i] > pre) {
                res++;
                continue;
            }
            if (pre == -1 || height[i] > pre) {
                process(height, count+1, i+1, height[i]);
            }
        }
    }

    private void process2(int[] height, int count, int index,int pre) {
        if (index == height.length) {
            return;
        }
        for (int i = index; i < height.length; i++) {
            if (count == 2 && height[i] < pre) {
                res++;
                continue;
            }
            if (pre == -1 || height[i] < pre) {
                process2(height, count+1, i+1, height[i]);
            }
        }
    }

    //[1,5,3,2,4]
    public static void main(String[] args) {
        int[] in = {1,5,3,2,4};
        int i = new Main1().TeamNums(in);
        System.out.println(i);
    }
}

/*
给你一组人，height数组
从这个数组中找三个人，i,j,k这三个人的高度height[i],height[j],height[k]必须逆序或者顺序排列
这三个人可以是多个小组的一部分

[1,5,3,2,4]
3
我们可以组建：1，3，4   1，2，4    5，3，2
 */
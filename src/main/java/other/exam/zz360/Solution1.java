package other.exam.zz360;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author keboom
 * @date 2021/8/29
 */
public class Solution1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int[] stu = new int[n];
        for (int i = 0; i < n; i++) {
            stu[i] = sc.nextInt();
        }
        Arrays.sort(stu);
        // 平时分为100
        int a = 100;
        // 及格人数
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            // 判断最后一个数
            if (i == n - 1) {
                // 期末分数b
                int b = stu[i];
                int grade = (p * a + q * b) / 100;
                if (grade < 60) {
                    System.out.println(count);
                    break;
                } else {
                    count++;
                }
            } else if (i < n - 1 && stu[i] == stu[i + 1]) {
                count++;
            } else {
                // 期末分数b
                int b = stu[i];
                a--;
                int grade = (p * a + q * b) / 100;
                if (grade < 60) {
                    System.out.println(count);
                    break;
                } else {
                    count++;
                }
            }
            if (i == 0) {
                System.out.println(count);
            }
        }

    }
}

/*
又到了一学期一次的大学生期末考试。但很多人期末考试的卷面成绩是不能及格的，需要靠较高的平时成绩来拖上去。平时成绩与期末考试的占比已经确定，假设平时成绩占比为p，期末考试占比为q，平时分为a，期末考试分数为b，则总成绩为(p*a+q*b)/100。（平时分与期末成绩都是整数，但总成绩可以是小数。）

       饶老师心肠特别好，他希望自己的学生及格率尽可能的高。但他也坚持期末考试分数更高的学生平时成绩也一定要更高。饶老师想知道在这种情况下，他们班的最大及格人数是多少（及格是指总成绩不低于60分）。


输入样例2

2 20 80

51 50

输出样例2

1



样例1中，两名同学，考试分数相同，平时分可以分配为100 100，两人都能及格。

样例2中，两名同学，第一位同学因为考试成绩高于第二位同学，故平时分也需要高于第二位同学；假设第一位同学平时分为100分，第二位同学最高只能得到99分的平时分，无论如何都无法及格。
 */